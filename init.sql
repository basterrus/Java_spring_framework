DROP TABLE users;
CREATE TABLE users (id BIGSERIAL, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name) VALUES ('Max');
INSERT INTO users (name) VALUES ('Stan');
INSERT INTO users (name) VALUES ('Mike');