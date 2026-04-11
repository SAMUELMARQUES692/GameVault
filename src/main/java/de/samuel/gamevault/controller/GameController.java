package de.samuel.gamevault.controller;

import de.samuel.gamevault.documention.GameControllerDoc;
import de.samuel.gamevault.dto.GameDTO;
import de.samuel.gamevault.enums.Platform;
import de.samuel.gamevault.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController implements GameControllerDoc {

    private final GameService service;

    @PostMapping
    public ResponseEntity<GameDTO> saveGame(@RequestBody GameDTO gameDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveGame(gameDTO));
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long id,@RequestBody @Valid GameDTO gameDTO) {
        return ResponseEntity.ok(service.updateGame(id, gameDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        service.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-platform")
    public ResponseEntity<List<GameDTO>> getByPlatform(@RequestParam List<Platform> platforms) {
        return ResponseEntity.ok(service.findByPlatform(platforms));
    }
}
