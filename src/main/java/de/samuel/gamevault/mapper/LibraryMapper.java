package de.samuel.gamevault.mapper;

import de.samuel.gamevault.dto.LibraryDTO;
import de.samuel.gamevault.model.GameModel;
import de.samuel.gamevault.model.LibraryModel;
import de.samuel.gamevault.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryMapper {

    public LibraryModel map(LibraryDTO libraryDTO) {
        UserModel user = new UserModel();
        user.setId(libraryDTO.userId());

        List<GameModel> games = libraryDTO.gameIds().stream()
                .map(gameId -> {
                    GameModel game = new GameModel();
                    game.setId(gameId);
                    return game;
                })
                .toList();

        return LibraryModel.builder()
                .id(libraryDTO.id())
                .user(user)
                .games(games)
                .build();
    }

    public LibraryDTO map(LibraryModel library) {
        List<Long> gameIds = library.getGames().stream()
                .map(GameModel::getId)
                .toList();

        return new LibraryDTO(
                library.getId(),
                library.getUser().getId(),
                gameIds
        );
    }
}


