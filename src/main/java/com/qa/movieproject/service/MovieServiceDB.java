package com.qa.movieproject.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.qa.movieproject.domain.Movie;
import com.qa.movieproject.repo.MovieRepo;

public class MovieServiceDB implements MovieService {

	private MovieRepo repo;

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie addMovie(Movie newMovie) {
		return this.repo.save(newMovie);
	}

	@Override
	public Movie getMovie(Integer id) {
		Optional<Movie> movieOptional = this.repo.findById(id);

		if (movieOptional.isPresent()) {
			Movie movie = movieOptional.get();
			return movie;
		} else {
			throw new EntityNotFoundException("This movie is not found with this id: " + id);
		}

	}

	@Override
	public Movie replaceMovie(Integer id, Movie newMovie) {
		Movie available = this.getMovie(id);

		available.setTitle(newMovie.getTitle());
		available.setGenre(newMovie.getGenre());
		available.setReleaseYear(newMovie.getReleaseYear());
		available.setRuntime(newMovie.getRuntime());

		return this.repo.save(available);
	}

	@Override
	public boolean removeMovie(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
