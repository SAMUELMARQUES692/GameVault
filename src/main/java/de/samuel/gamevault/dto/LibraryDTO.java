package de.samuel.gamevault.dto;

import java.util.List;

public record LibraryDTO(Long id, Long userId, List<Long> gameIds) {
}
