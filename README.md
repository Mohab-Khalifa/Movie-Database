# DFEFinal Project - Movie-Database


## Introduction

The purpose of this project is to encapsulate concepts from all the core trainging modules - more specifically, this will include: 

- Agile & Project Management(Git, Jira) 
- Databases & Cloud fundamentals (H2, MySQL) 
- Programming Fundamentals (Java) 
- API Development (Spring Boot) 
- Automated Testing (JUnit) 


## Agile 

This project was create using Agile project management through Jira 


## Scope 

- Code fully integrated into a Version Control System using the feature-branch model: main/dev/multiple features 
- A project managment board (Jira) with full expansion on user stories, acceptance criteria and tasks needed to complete the project 
- A risk assessment which outlines the issues and risks faced during the project timeframe 
- A relational database, locally or within the Cloud, which is used to persist data for the project 
- A functional application ‘back-end’, written in a suitable framework of the language covered in training (Java/Spring Boot), which meets the requirements set on your Scrum Kanban board 
- A build (.jar) of your application, including any dependencies it might need, produced using an integrated build tool (Maven) 
- A series of API calls designed with postman, used for CRUD functionality. (Create, Read, Update, Delete) 
- Fully designed test suites for the application you are creating, including both unit and integration tests 


## Why are we doing this? 

The aim of this project is to put into practise everything we have learnt during our time in the QA Academy Software Developer Bootcamp. Creating a simple application that is capable of interacting with a database while also sticking to DevOps practices which coincides with the fundamental principles with the industry. 


## How I expected the challenge to go 

Based on all the quality of teaching in the QA Academy, I believed they prepared us as much as they could in such a short matter of time, however I was anxious in the lead up to the project as it was my first ever full project. Leading from this I was expecting to make a lot of mistakes, so I was cautious writing every piece of code to prevent myself from having to go back and fixing a lot of code. My biggest worry was not sticking to the Jira plan as I had little to no experience with Jira throughout the bootcamp other than a brief introduction on week one. I would simply say that was my biggest struggle and aim to improve my use of jira in the future as it will be more useful when working in an actual team rather than working by yourself. 


## What went well? 

- Setting up Spring
- Setting up Github
- Creating my API went smoothly 
- Integration testing went better than expected, although there were some mishaps I had to overcome


## What didn't go as planned? 

- I found Jira difficult to stick to as I had little to no practise with it 
- I did not stick to my Jira plan as well as I wanted to 
- My tickets were not clear enough and did contain to much detail as I didn't feel it was needed 
- Unit testing was slightly more challenging for me than integration 
- Compiling my code into .jar 
- I did not know what I did, but I somehow corrupted my local git repo, so I had to delete the local repo and pull it from Github which was a couple commits behind, so I had to redo 
- Connecting to MySQL was slightly confusing at first 


## Possible improvements 

- Create a better plan/structure before starting my project 
- Possibly not create a service list next time (used it for practice) 
- Wanted to complete some of the stretch goals which I will do after the bootcamp
- Add more functionality to my API 
- Advance from simple to more complex API 


# Functionality Screenshots 

## Postman requests & the output from the API 

### CRUD - Create 

```
// Create - adding a movie
@PostMapping("/add-movie") // triggering a post request
public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) { // inserting the movie object in the request body
  Movie responseBody = this.service.addMovie(newMovie);
  return new ResponseEntity<Movie>(responseBody, HttpStatus.CREATED);
}
```
Image below shows a 'Post Request', creating my first obect "Inception".
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/Postman%20-%20Post%20Request%20V2.PNG" width="100%"></img> 

This shows proof of persistence as it is stored locally in my MySQL database.
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/MySql%20-%20Create%20Persistence%20V2.PNG" width="100%"></img> 

Created another object "Shutter Island".
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/Postman%20-%20Post%20Request%20second%20pic%20V2.PNG" width="100%"></img> 

### CRUD - Read

```
// Read - getting the whole list of movies
@GetMapping("/getAllMovies")
public ResponseEntity<List<Movie>> getMovies() {
  List<Movie> responseBody = this.service.getMovies();
  return new ResponseEntity<List<Movie>>(responseBody, HttpStatus.OK);
	}
```
This image shows the 'Get Request' that reads the objects i have created, "inception" and "Shutter Island".
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/Postman%20-%20Get%20Request%20V2.PNG" width="100%"></img> 

Again shows proof of persistence containing both objects I have created.
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/MySql%20-%20Create%20Persistence%20second%20pic%20V2.PNG" width="100%"></img> 

### CRUD - Update

```
// Update
@PutMapping("/replace-movie/{id}")
public ResponseEntity<Movie> replaceMovie(@PathVariable Integer id, @RequestBody Movie newMovie) {
  System.out.println("Replacing movie with id " + id + " with " + newMovie);
  Movie movieChange = this.service.replaceMovie(id, newMovie); // replaces the movie at the index
  return new ResponseEntity<Movie>(movieChange, HttpStatus.ACCEPTED);
}
```
This image below shows a 'Put Request', updating the "Shutter Island" object into another "Inception" object. Thus creating a duplicate.
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/Postman%20-%20Put%20Request%20V2.PNG" width="100%"></img> 

Also shown in MySQL db containing the duplicate object now.
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/MySql%20-%20Update%20Persistence%20V2.PNG" width="100%"></img> 

### CRUD - Delete

```
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
```
Since I don't need two of the same movie, I made a 'Delete Request' which removed one of the objects(movie).
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/Postman%20-%20Delete%20Request%20V2.PNG" width="100%"></img>

Now MySQL only contains one "Inception" again.
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/MySql%20-%20Delete%20Persistence%20V2.PNG" width="100%"></img>

## Coverage Test Screenshot

The target coverage I had to reach in the src/main/java was a minimum of 60%. This image clearly shows that I have reached 90.5% coverage in my src/main/java. 
<img src="https://github.com/Mohab-Khalifa/Movie-Database/blob/feature/MKP-19/screenshots/Coverage%20Test%20Screenshot.PNG" width="100%"></img>

# Jira Board Link

https://mohabkhalifa.atlassian.net/jira/software/projects/MKP/boards/1
