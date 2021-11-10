package com.qa.movieproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // tells the DB to create table with attributes as fields
public class Movie {

	// Attributes

	@Id // tells Spring this is the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT private integer id
	private Integer id;

	private String title;
	private Integer releaseYear;
	private String genre;
	private int runtime;

	// Default Constructor
	public Movie() {
		super();
	}

	// Constructor
	public Movie(String title, Integer releaseYear, String genre, int runtime) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.runtime = runtime;
	}

	// Contructor 2 (includes id)
	public Movie(Integer id, String title, Integer releaseYear, String genre, int runtime) {
		super();
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.runtime = runtime;
	}

	// Getters & Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	// ToString
	@Override
	public String toString() {
		return "Movie [Title=" + title + ", releaseYear=" + releaseYear + ", Genre=" + genre + ", runtime=" + runtime
				+ "]";
	}

}
