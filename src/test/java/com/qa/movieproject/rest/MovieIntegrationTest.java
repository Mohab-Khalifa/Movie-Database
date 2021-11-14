package com.qa.movieproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.movieproject.domain.Movie;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // boots the entire context
@AutoConfigureMockMvc // creates the MockMVC object for sending the test requests
@Sql(scripts = { "classpath:movie-schema.sql",
		"classpath:movie-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD) // runs schema and data file
																							// before each test

public class MovieIntegrationTest {

	@Autowired // enables automatic dependency injection
	private MockMvc mvc; // using MockMvc to perform the integration testing using Junit
	// we can leverage the Spring MVC test
	// framework in order to write and run integration tests that test controller
	// without explicitly starting a Servlet container

	@Autowired // injection without a constructor
	private ObjectMapper mapper; // same mapper that spring uses to convert objects to and from JSON

	@Test
	void testAdd() throws Exception {
		Movie requestBody = new Movie("Inception", 2010, "Thriller", 138); // creating object for the test
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/add-movie").contentType(MediaType.APPLICATION_JSON).content(requestBodyAsJSON);
		// this sets up the test request^

		Movie responseBody = new Movie(2, "Inception", 2010, "Thriller", 138); // creating what the expected value
																				// should be

		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated(); // checks the status code of 201
		ResultMatcher checkBody = content().json(responseBodyAsJSON); // checks that the body matches the example

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody); // performs request and checks response

	}

//	@Test
//	void testMovieNotFound() throws Exception {
//		this.mvc.perform(get("/get-movie/7849")).andExpect(status().isNotFound());
//	}

	@Test
	void testGetAll() throws Exception {

		RequestBuilder request = get("/getAllMovies");
		ResultMatcher checkStatus = status().isOk();

		Movie movie = new Movie(1, "Inception", 2010, "Thriller", 138);
		List<Movie> movies = List.of(movie);
		String responseBody = this.mapper.writeValueAsString(movies);
		ResultMatcher checkBody = content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGet() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new Movie(1, "Inception", 2010, "Thriller", 138));
		this.mvc.perform(get("/get-movie/1")).andExpect(status().isOk()).andExpect(content().json(responseBody));
	}

	@Test
	void testReplace() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new Movie(1, "Inception", 2010, "Thriller", 138));

		RequestBuilder request = put("/replace-movie/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/remove-movie/1")).andExpect(status().isNoContent());
	}

}
