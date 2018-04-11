package com.netapp.ads;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class MockTest {

	//@Autowired
    private MockMvc mockMvc;
	
	//@Autowired
	private OAuthHelper oAuthHelper;
	
	//@Test
	public void withMockUser() throws Exception {
	    //this.mockMvc.perform(get("/").with(oAuthHelper.bearerToken())).andExpect(status().isOk());

		//MvcResult result = this.mockMvc.perform(get("/").with(oAuthHelper.mockRequestBearerToken())).andReturn();
	    //System.out.println(" ****************** " + result.getResponse().getContentAsString());	
	}
}
