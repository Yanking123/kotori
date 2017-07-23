package cc.kotori.sboot.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cc.kotori.sboot.web.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

	private MockMvc mvc;
	
	@Before
	public void setUp() 
	{
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void testUserInfo() throws Exception
	{
		MvcResult res = mvc.perform(MockMvcRequestBuilders.get("/user/info").param("id", "666"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andReturn();
		
		String content = res.getResponse().getContentAsString();
		System.out.println(content);
	}

}
