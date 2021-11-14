package com.qa.movieproject.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.qa.movieproject.domain.Movie;

public class MovieTest {

	Movie movie = new Movie(1, "Inception", 2010, "Thriller", 138);
	Movie movie2 = new Movie("Inception", 2010, "Thriller", 138);
	Movie movie3 = new Movie();

	@Test
	public void testGetId() {
		assertEquals(1, movie.getId());
	}

	@Test
	public void testSetId() {
		assertEquals(1, movie.getId());
		movie.setId(2);
		assertEquals(2, movie.getId());
	}

	@Test
	public void testGetTitle() {
		assertEquals("Inception", movie.getTitle());
	}

	@Test
	public void testSetTitle() {
		assertEquals("Inception", movie.getTitle());
		movie.setTitle("Shutter Island");
		assertEquals("Shutter Island", movie.getTitle());
	}

	@Test
	public void testGetReleaseYear() {
		assertEquals(2010, movie.getReleaseYear());
	}

	@Test
	public void testSetReleaseYear() {
		assertEquals(2010, movie.getReleaseYear());
		movie.setReleaseYear(2011);
		assertEquals(2011, movie.getReleaseYear());
	}

	@Test
	public void testGetGenre() {
		assertEquals("Thriller", movie.getGenre());
	}

	@Test
	public void testSetGenre() {
		assertEquals("Thriller", movie.getGenre());
		movie.setGenre("Comedy");
		assertEquals("Comedy", movie.getGenre());
	}

	@Test
	public void testGetRuntime() {
		assertEquals(138, movie2.getRuntime());
	}

	@Test
	public void testSetRuntime() {
		assertEquals(138, movie2.getRuntime());
		movie2.setRuntime(140);
		assertEquals(140, movie2.getRuntime());
	}

}
