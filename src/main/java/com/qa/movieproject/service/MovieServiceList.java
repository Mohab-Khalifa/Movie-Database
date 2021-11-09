package com.qa.movieproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.movieproject.domain.Movie;

@Service // mark beans with @Service to indicate that they're holding the business logic
public class MovieServiceList implements MovieService {

	private List<Movie> moviesList = new ArrayList<>();

	@Override
	public List<Movie> getMovies() {
		return this.moviesList;
	}

	@Override
	public Movie addMovie(Movie newMovie) {
		this.moviesList.add(newMovie);
		return this.moviesList.get(this.moviesList.size() - 1);
	}

	@Override
	public Movie getMovie(Integer id) {
		return this.moviesList.get(id);
	}

	@Override
	public Movie replaceMovie(Integer id, Movie newMovie) {
		return this.moviesList.set(id, newMovie); // replaces human at index
	}

	@Override
	public boolean removeMovie(Integer id) {
		Movie removeMovie = this.moviesList.get(id);
		this.moviesList.remove(id.intValue());
		return !this.moviesList.contains(removeMovie);
	}

}
