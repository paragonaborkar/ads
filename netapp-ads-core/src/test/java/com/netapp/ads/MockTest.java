package com.netapp.ads;

import org.springframework.test.web.servlet.MockMvc;

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
