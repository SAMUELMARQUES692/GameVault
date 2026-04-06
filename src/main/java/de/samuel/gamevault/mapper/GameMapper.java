package de.samuel.gamevault.mapper;

import de.samuel.gamevault.dto.GameDTO;
import de.samuel.gamevault.model.GameModel;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameModel map(GameDTO gameDTO) {

        GameModel game = new GameModel();
        game.setId(gameDTO.id());
        game.setName(gameDTO.name());
        game.setDescription(gameDTO.description());
        game.setGenre(gameDTO.genre());
        game.setPlatforms(gameDTO.platforms());
        game.setPrice(gameDTO.price());
        game.setRating(gameDTO.rating());

        return game;
    }

    public GameDTO map(GameModel game) {

        return new GameDTO(
                game.getId(),
                game.getName(),
                game.getDescription(),
                game.getGenre(),
                game.getPlatforms(),
                game.getPrice(),
                game.getRating());
    }

}
