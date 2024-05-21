create database eazybank;

use eazybank;

CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

INSERT INTO authorities (username, authority)
VALUES ('piyush', 'write'), ('bittu', 'write');

INSERT INTO users (username, password, enabled)
VALUES ('piyush', 'piyush', 1), ('bittu', 'bittu', 1);

create table customer (
    id int Not null auto_increment,
    email varchar(45) not null,
    pwd varchar(200) not null,
    role varchar(45) not null,
    primary key (id)
);

INSERT INTO customer (email, pwd, role)
VALUES ('piyush@gmail.com', '123456', 'admin'), ('bittu@gmail.com', '123456', 'admin');
