DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS avatars;

CREATE TABLE avatars(
    id INT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(255) NOT NULL
);

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    avatar_id INT,
    foreign key (avatar_id) references avatars(id)
);


INSERT INTO avatars(id, url) VALUES (1, 'cat.png');
INSERT INTO avatars(id, url) VALUES (2, 'dog.png');
INSERT INTO users(id, name, email, avatar_id) VALUES (1, 'Jonh', 'john@mail.com', 1);
INSERT INTO users(id, name, email, avatar_id) VALUES (2, 'Anna', 'anna@mail.com', 2);
