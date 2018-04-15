package com.netapp.ads;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@RunWith(MockitoJUnitRunner.class)
public class RestEndPointsTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	//@InjectMocks
	private OAuthHelper oAuthHelper;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	private TestRestTemplate testRestTemplate = new TestRestTemplate();
	
	private static final Logger log = LoggerFactory.getLogger(RestEndPointsTest.class);
	
	@Before
	public void setUp() {
		testRestTemplate.getRestTemplate().setInterceptors(
		        Collections.singletonList((request, body, execution) -> {
		            request.getHeaders()
		                    .add(OAuthHelper.AUTHORIZATION_HEADER, oAuthHelper.getBearerToken());
		            return execution.execute(request, body);
		        }));
	}
	
	@Test
	public void endPointGetRquests() throws JsonProcessingException, IOException {
		final Resource endpointsJsonFile = resourceLoader.getResource("classpath:test/gets/endpoints_get.json");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(endpointsJsonFile.getInputStream());
		Iterator<String> fieldNames = rootNode.fieldNames();
		while(fieldNames.hasNext()) {
			String endPointUrl = "http://localhost:" + port + "/" + fieldNames.next();
			log.debug("endPointUrl: " + endPointUrl);
			ResponseEntity<String> childResponse = testRestTemplate.getForEntity(endPointUrl, String.class);
			assertEquals(HttpStatus.OK, childResponse.getStatusCode());
		}
	}
	
	@Test
	public void endPointPostAndDeleteRquests() throws JsonProcessingException, IOException {
		final Resource endpointsJsonFile = resourceLoader.getResource("classpath:test/posts/endpoints_post.json");
	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(endpointsJsonFile.getInputStream());
		Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		while(fields.hasNext()) {
			Map.Entry<String, JsonNode> field = fields.next();
			String endPointUrl = "http://localhost:" + port + "/" + field.getKey();
			log.debug("endPointUrl: " + endPointUrl);
			log.debug("JSON for this endPoint: " + field.getValue().toString());
			
			HttpEntity<String> entity = new HttpEntity<String>(field.getValue().toString(), headers);
			
			ResponseEntity<String> postResponseEntity = testRestTemplate.postForEntity(endPointUrl, entity, String.class);
			log.debug("POSTED: Status Code:  " + postResponseEntity.getStatusCode() + " , URI: " + postResponseEntity.getHeaders().getLocation());
			assertEquals(HttpStatus.CREATED, postResponseEntity.getStatusCode());
			
			ResponseEntity<String> deleteResponseEntity = testRestTemplate.exchange(postResponseEntity.getHeaders().getLocation(), HttpMethod.DELETE, entity, String.class);
			log.debug("DELETE responseEntity: " + deleteResponseEntity);
			log.debug("DELETE responseEntity: getStatusCode: " + deleteResponseEntity.getStatusCode());
			//assertTrue(deleteResponseEntity.toString().contains("204"));
			assertEquals(HttpStatus.NO_CONTENT, deleteResponseEntity.getStatusCode());
		}		
	}
	
	
}
