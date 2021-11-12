package com.qa.movieproject.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // boots the entire context
@AutoConfigureMockMvc // creates the MockMVC object for sending the test requests
public class MovieIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void test1() {

	}

}
