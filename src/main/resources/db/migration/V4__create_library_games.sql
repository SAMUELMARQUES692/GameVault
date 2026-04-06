CREATE TABLE library_games (
library_id serial NOT NULL,
game_id serial NOT NULL,
PRIMARY KEY (library_id, game_id),
CONSTRAINT fk_library FOREIGN KEY (library_id) REFERENCES libraries(id) ON DELETE CASCADE,
CONSTRAINT fk_game FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);