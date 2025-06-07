DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);


-- В реальном приложении пароль не хранится в базе данных в открытом виде
-- Он хешируется перед записью и в базе хранится уже хеш пароля
-- Но здесь, с целью немного упростить решение, будем хранить и сравнивать его как есть
INSERT INTO users (id, name, password) VALUES
(1, 'admin', 'strong_password');



