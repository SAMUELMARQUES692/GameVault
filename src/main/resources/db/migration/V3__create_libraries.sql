CREATE TABLE libraries (
id serial PRIMARY KEY,
user_id serial NOT NULL UNIQUE,
CONSTRAINT fk_library_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);