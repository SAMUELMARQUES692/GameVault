package de.samuel.gamevault.service;

import de.samuel.gamevault.dto.GameDTO;
import de.samuel.gamevault.exception.GameNotFoundException;
import de.samuel.gamevault.mapper.GameMapper;
import de.samuel.gamevault.model.GameModel;
import de.samuel.gamevault.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapper mapper;

    public GameDTO saveGame(GameDTO gameDTO) {
        return mapper.map(gameRepository.save(mapper.map(gameDTO)));
    }

    public List<GameDTO> getAll() {
        return gameRepository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    public GameDTO getById(Long id) {
        return gameRepository.findById(id)
                .map(mapper::map)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    public GameDTO updateGame(Long id, GameDTO gameDTO) {
        gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));

        GameModel updatedGame = mapper.map(gameDTO);
        updatedGame.setId(id);

        return mapper.map(gameRepository.save(updatedGame));
    }

    public void deleteGame(Long id) {
        GameModel game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
        gameRepository.delete(game);
    }
}
