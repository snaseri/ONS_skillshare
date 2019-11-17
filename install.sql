CREATE DATABASE IF NOT EXISTS SkillsDB;

USE SkillsDB;

CREATE TABLE IF NOT EXISTS Users (
    id  INT NOT NULL PRIMARY KEY ,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Teams (
    id INT NOT NULL PRIMARY KEY ,
    name VARCHAR(50),
    descripion TEXT
);

CREATE TABLE IF NOT EXISTS AssociatedTeams (
    id INT NOT NULL PRIMARY KEY,
    user_id INT NOT NULL,
    team_id INT NOT NULL,
    left_team DATETIME,
    joined_team DATETIME,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (team_id) REFERENCES Teams(id)
);

CREATE TABLE IF NOT EXISTS Skills (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT(300) NOT NULL
);

CREATE TABLE IF NOT EXISTS Types (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Courses (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL ,
    descripion TEXT NOT NULL ,
    is_free BOOLEAN,
    price DECIMAL,
    date DATETIME NOT NULL,
    user_creator INT NOT NULL,
    skill_id INT NOT NULL,
    FOREIGN KEY (user_creator) REFERENCES Users(id),
    FOREIGN KEY (skill_id) REFERENCES  Skills(id)
);

CREATE TABLE IF NOT EXISTS Adverts (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL ,
    descripion TEXT NOT NULL ,
    posted DATETIME,
    user_creator INT NOT NULL,
    skill_id INT NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (user_creator) REFERENCES Users(id),
    FOREIGN KEY (skill_id) REFERENCES Skills(id),
    FOREIGN KEY (type_id) REFERENCES Types(id)
);

CREATE TABLE IF NOT EXISTS Reviews (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(50) NOT NULL ,
    descripion TEXT NOT NULL ,
    course_id INT NOT NULL,
    user_creator INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Courses(id),
    FOREIGN KEY (user_creator) REFERENCES Users(id)
);

CREATE TABLE IF NOT EXISTS Comments (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(50) NOT NULL ,
    descripion TEXT NOT NULL ,
    advert_id INT NOT NULL,
    user_creator INT NOT NULL,
    FOREIGN KEY (advert_id) REFERENCES Adverts(id),
    FOREIGN KEY (user_creator) REFERENCES Users(id)
);