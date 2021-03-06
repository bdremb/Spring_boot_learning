DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE books
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    bookId   INT NOT NULL,
    title    VARCHAR(250) NOT NULL,
    priceOld VARCHAR(250) DEFAULT NULL,
    price    VARCHAR(250) DEFAULT NULL
);

CREATE TABLE authors
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    author   VARCHAR(250) NOT NULL,
    bookId   INT NOT NULL
);
