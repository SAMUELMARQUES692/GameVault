package de.samuel.gamevault.controller;

import de.samuel.gamevault.documention.LibraryControllerDoc;
import de.samuel.gamevault.dto.LibraryDTO;
import de.samuel.gamevault.service.LibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/libraries")
public class LibraryController implements LibraryControllerDoc {

    private final LibraryService service;

    @PostMapping
    public ResponseEntity<LibraryDTO> saveLibrary(@RequestBody @Valid LibraryDTO libraryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveLibrary(libraryDTO));
    }

    @GetMapping
    public ResponseEntity<List<LibraryDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryDTO> updateById(@PathVariable Long id, @RequestBody @Valid LibraryDTO libraryDTO) {
        return ResponseEntity.ok(service.updateById(id, libraryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
