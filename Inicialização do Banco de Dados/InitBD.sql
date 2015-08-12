CREATE TABLE usuario (
id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
username VARCHAR(30),
password VARCHAR(30)
);

INSERT INTO usuario (username, password) VALUES ('admin', 'admin');
