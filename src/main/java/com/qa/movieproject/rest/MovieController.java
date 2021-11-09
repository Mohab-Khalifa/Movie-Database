package com.qa.movieproject.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.movieproject.domain.Movie;

@RestController // this is a specialised version of the controller. It includes the @Controller
				// and
				// @ResponseBody annotations, and as a result, simplifies the controller
				// implementation
				// simply... enables request handling
@RequestMapping
public class MovieController {

	// Creating a private list because I am not implementing the DB yet
	private List<Movie> movies = new ArrayList<>();

	// Test get request
	@GetMapping("/hey") // listens for a request at /hey
	public String greetYou() {
		return "Hey there!"; // sends response
	}

	@PostMapping("/create-movie") // triggering a post request
	public Movie createMovie(@RequestBody Movie newMovie) { // inserting the human object in the request body

		this.movies.add(newMovie);
		return this.movies.get(this.movies.size() - 1); // returning the most recently added
	}

	@GetMapping("/getAllMovies")
	public List<Movie> getMovies() {
		return this.movies;
	}

	// Getting a specific index in the list
	@GetMapping("/get/{1}") // getMovie with id of {id}
	public Movie getMovie(@PathVariable Integer id) {
		return this.movies.get(id);
	}

}
