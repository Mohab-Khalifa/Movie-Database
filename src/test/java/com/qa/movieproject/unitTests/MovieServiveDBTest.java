package com.qa.movieproject.unitTests;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.movieproject.domain.Movie;
import com.qa.movieproject.repo.MovieRepo;
import com.qa.movieproject.service.MovieService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieServiveDBTest {

	@Autowired
	private MovieService service;

	@MockBean
	private MovieRepo repo;

	@Test
	void testAddMovie() {

		// GIVEN
		Movie toSave = new Movie("Inception", 2010, "Thriller", 138);
		Movie saved = new Movie("Inception", 2010, "Thriller", 138);

		// WHEN
		Mockito.when(this.repo.save(toSave)).thenReturn(saved);

		// THEN
		Assertions.assertThat(this.service.addMovie(toSave)).isEqualTo(saved);

		// verify
		Mockito.verify(this.repo, Mockito.times(1)).save(toSave);

	}

	@Test
	void testReplaceMovie() {

		// GIVEN
		Integer id = 1;
		Movie newValues = new Movie("Inception", 2010, "Thriller", 138);
		Movie existing = new Movie("Inception", 2010, "Thriller", 138);
		Movie updated = new Movie(newValues.getTitle(), newValues.getReleaseYear(), newValues.getGenre(),
				newValues.getRuntime());

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		// THEN
		Assertions.assertThat(this.service.replaceMovie(id, newValues)).isEqualTo(updated);

		// verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	}

	@Test
	void testGetMovies() {

		// GIVEN
		Integer id = 1;
		Movie testMovie = new Movie("Inception", 2010, "Thriller", 138);
		testMovie.setId(id);
		List<Movie> movies = List.of(testMovie);

		// WHEN
		Mockito.when(this.repo.findAll()).thenReturn(movies);

		// THEN
		Assertions.assertThat(this.repo.findAll()).isEqualTo(movies);

		// verify
		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	void testDelete() {

		// GIVEN
		Integer id = 1;

		// WHEN
		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		// THEN
		Assertions.assertThat(this.service.delete(id)).isTrue();

		// verify
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	}

}
