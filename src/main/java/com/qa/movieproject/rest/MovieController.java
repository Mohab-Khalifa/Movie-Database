package com.qa.movieproject.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.movieproject.domain.Movie;

@RestController // this is a specialised version of the controller. It includes the @Controller
				// and
				// @ResponseBody annotations, and as a result, simplifies the controller
				// implementation
				// simply... enables request handling

public class MovieController {

	// Creating a private list because I am not implementing the DB yet
	private List<Movie> movies = new ArrayList<>();

	@GetMapping("/hey") // listens for a request at /hey
	public String greetYou() {
		return "Hey there!"; // sends response
	}

}
