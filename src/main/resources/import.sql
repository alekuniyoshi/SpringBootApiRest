INSERT INTO client (name, last_name, email, create_at) VALUES('Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-01');
INSERT INTO client (name, last_name, email, create_at) VALUES('John', 'Doe', 'john.doe@gmail.com', '2017-08-02');
INSERT INTO client (name, last_name, email, create_at) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2017-08-03');
INSERT INTO client (name, last_name, email, create_at) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04');
INSERT INTO client (name, last_name, email, create_at) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05');
INSERT INTO client (name, last_name, email, create_at) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2017-08-06');
INSERT INTO client (name, last_name, email, create_at) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2017-08-07');
INSERT INTO client (name, last_name, email, create_at) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2017-08-08');
INSERT INTO client (name, last_name, email, create_at) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2017-08-09');
INSERT INTO client (name, last_name, email, create_at) VALUES('James', 'Gosling', 'james.gosling@gmail.com', '2017-08-010');

INSERT INTO usuarios (username,password,enabled) VALUES ('andres','$2a$10$CLOY6bZjL4Kn7OV8GY9H1eTB4kZadakEbc3IPbZCvsupZVqnUleM2',1)
INSERT INTO usuarios (username,password,enabled) VALUES ('admin','$2a$10$0CXvfpaitks1/per872vhe8TedIxrmREEbtDaf4h171b.i.FXwMQu',1)


INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuario_roles (usuario_id,role_id) VALUES (1,1);
INSERT INTO usuario_roles (usuario_id,role_id) VALUES (2,2);
INSERT INTO usuario_roles (usuario_id,role_id) VALUES (2,1);
