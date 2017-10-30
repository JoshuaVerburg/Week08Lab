DROP DATABASE if exists NotesDB;
CREATE DATABASE NotesDB;

USE NotesDB;




CREATE TABLE Notes( 
    noteid INT NOT NULL AUTO_INCREMENT,
    dateCreated DATETIME NOT NULL,
    contents VARCHAR(10000) CHARACTER SET utf8 NOT NULL,
    PRIMARY KEY (noteID)
);

INSERT INTO `Notes` (`DateCreated`, `Contents`) VALUES (NOW(), 'Sample note 1');
