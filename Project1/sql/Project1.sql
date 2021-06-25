drop table stories;

create table genres (
	genre_id serial primary key,
	genre varchar(30) unique not null 
);

create table authors (
	author_id serial primary key,
	author_username varchar(30) unique not null,
	author_pass varchar(30) not null,
	author_firstname varchar(30) not null,
	author_lastname varchar(30) not null,
	author_points integer not null
);

create table storyTypes (
	story_type_id serial primary key,
	story_type varchar (30) unique not null
);

create table stories (
	story_id serial primary key,
	story_title varchar(30) unique not null,
	story_tagline text not null,
	story_description text not null,
	story_completion_date date not null,
	story_genre integer not null,
	story_type integer not null,
	story_status integer not null,
	author_id integer not null,
	constraint story_genre_FK foreign key(story_genre) references genres(genre_id),
	constraint story_type_FK foreign key(story_type) references storyTypes(story_type_id),
	constraint story_status_FK foreign key(story_status) references statuses(story_status_id),
	constraint story_author_id_FK foreign key(author_id) references authors(author_id)
);

create table authorInfo(
	author_info_id serial primary key,
	author_info text
);

create table generalInfo(
	general_info_id serial primary key,
	general_info text
);

create table assistantInfo(
	assistant_info_id serial primary key,
	assistant_info text
);

create table statuses (
	story_status_id serial primary key,
	status varchar(30) not null,
	priority varchar(30) not null,
	author_info integer,
	generalInfo integer,
	assistant_info integer,
	constraint status_author_info_FK foreign key(author_info) references authorInfo(author_info_id),
	constraint status_general_info_FK foreign key(generalInfo) references generalInfo(general_info_id),
	constraint status_assitant_info_FK foreign key(assistant_info) references assistantInfo(assistant_info_id)
);

create table approval(
	approval_id serial primary key,
	story_status integer,
	approval_status varchar(30) not null,
	approval_info text,
	number_of_approves integer not null
);

create table employees(
	employee_id serial primary key,
	employee_username varchar(30) unique not null,
	employee_password varchar(30) not null,
	employee_firstname varchar(30) not null,
	employee_lastname varchar(30) not null,
	employee_type varchar(30) not null,
	genre integer not null,
	genre2 integer,
	genre3 integer,
	story integer,
	story2 integer,
	story3 integer,
	constraint employee_genre_FK foreign key(genre) references genres(genre_id),
	constraint employee_genre2_FK foreign key(genre2) references genres(genre_id),
	constraint employee_genre3_FK foreign key(genre3) references genres(genre_id),
	constraint employee_story_FK foreign key(story) references stories(story_id),
	constraint employee_story2_FK foreign key(story2) references stories(story_id),
	constraint employee_story3_FK foreign key(story3) references stories(story_id)
);


alter table approval 
add constraint story_status_FK
foreign key(story_status) references statuses(story_status_id);

alter table stories add author_id integer not null;

alter table stories 
add constraint story_author_id_FK
foreign key(author_id) references authors(author_id);

insert into genres values 
(default, 'Fantasy'),
(default, 'Si-Fi'),
(default, 'Myster'),
(default, 'Dystopian'),
(default, 'Horror'),
(default, 'Romance');

insert into authors values 
(default, 'matt', 'password', 'Matt', 'Anderson', 100),
(default, 'sarahj', 'password', 'Sarah', 'Mass', 50),
(default, 'cpao', 'password', 'Christopher', 'Paolini', 0),
(default, 'gmart', 'password', 'George', 'Martin', 100),
(default, 'jkr', 'password', 'J.K.', 'Rowling', 100);

insert into storyTypes values 
(default, 'novel'),
(default, 'novella'),
(default, 'short-story'),
(default, 'article');

insert into statuses values 
(default, 'Approved', 'none', null, null, null);

insert into statuses values 
(default, 'Approved', 'none', null, 1, null);

insert into stories values
(default, 'Eragon', 'Dragon Riders in Alagaesia', 'A young boy named Eragon finds a dragon egg while on a hunt, and his life changes forever...', '08-26-2002', '1', '1', '1', '3');

insert into generalInfo values
(default, 'You look like a potatoe');

select * from authors;

select * from employees;

select * from stories;

select * from statuses;

select * from storyTypes;

select * from genres;

select story_title, general_info
from stories left join statuses on story_id = story_status_id left join generalInfo on story_status_id = general_info_id 
where story_status_id =2;








