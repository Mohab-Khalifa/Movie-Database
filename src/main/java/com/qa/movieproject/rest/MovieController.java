package com.qa.movieproject.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.movieproject.domain.Movie;
import com.qa.movieproject.service.MovieService;

@RestController // this is a specialised version of the controller. It includes the @Controller
				// and
				// @ResponseBody annotations, and as a result, simplifies the controller
				// implementation
				// simply... enables request handling
@RequestMapping
public class MovieController {

	private MovieService service;

	public MovieController(MovieService service) { // dependency injection from outside the class
		super();
		this.service = service;
	}

//	// Test get request
//	@GetMapping("/hey") // listens for a request at /hey
//	public String greetYou() {
//		return "Hey there!"; // sends response
//	}

	// Create - adding a movie
	@PostMapping("/add-movie") // triggering a post request
	public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) { // inserting the movie object in the request body
		Movie responseBody = this.service.addMovie(newMovie);
		return new ResponseEntity<Movie>(responseBody, HttpStatus.CREATED);
	}

	// Read - getting the whole list of movies
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> getMovies() {
		List<Movie> responseBody = this.service.getMovies();
		return new ResponseEntity<List<Movie>>(responseBody, HttpStatus.OK);
	}

	// Read - Getting a specific index in the list
	@GetMapping("/get-movie/{id}") // picks movie with id of {id}
	public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
		Movie responseBody = this.service.getMovie(id);
		return new ResponseEntity<Movie>(responseBody, HttpStatus.OK);
	}

	// Update
	@PutMapping("/replace-movie/{id}")
	public ResponseEntity<Movie> replaceMovie(@PathVariable Integer id, @RequestBody Movie newMovie) {
		System.out.println("Replacing movie with id " + id + " with " + newMovie);
		Movie movieChange = this.service.replaceMovie(id, newMovie); // replaces the movie at the index
		return new ResponseEntity<Movie>(movieChange, HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/remove-movie/{id}")
	public ResponseEntity<Movie> removeMovie(@PathVariable Integer id) {
		System.out.println("Removing movie with id " + id);
		Movie toRemove = this.service.getMovie(id);
		this.service.removeMovie(id.intValue()); // removes object
		@SuppressWarnings("unlikely-arg-type")
		boolean removed = !this.service.equals(toRemove);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
