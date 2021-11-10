package com.qa.movieproject.service;

import java.util.List;

import com.qa.movieproject.domain.Movie;

//This contains the CRUD functionality
public interface MovieService {

	List<Movie> getMovies();

	Movie addMovie(Movie newMovie);

	Movie getMovie(Integer id);

	Movie replaceMovie(Integer id, Movie newMovie);

	boolean removeMovie(Integer id);

}
