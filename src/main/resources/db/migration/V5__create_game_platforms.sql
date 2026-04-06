CREATE TABLE game_platforms (
game_id serial NOT NULL,
platform VARCHAR(50) NOT NULL,
CONSTRAINT fk_game_platform FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);