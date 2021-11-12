package com.qa.movieproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.movieproject.domain.Movie;

@Repository // this indicates that the the decorated class is a repository
// @Repository’s job is to catch persistence-specific exceptions and re-throw 
// them as one of Spring’s unified unchecked exceptions.
public interface MovieRepo extends JpaRepository<Movie, Integer> {// this contains API for basic CRUD operations

}
