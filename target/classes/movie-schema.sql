drop table if exists `movie`;
create table
	`movie`
	 
(
	
	id integer AUTO_INCREMENT, 
	genre varchar(255), 
	release_year integer, 
	runtime integer not null, 
	title varchar(255), 
	primary key (id)
		
);