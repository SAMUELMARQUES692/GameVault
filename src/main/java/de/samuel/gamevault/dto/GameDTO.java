package de.samuel.gamevault.dto;

import de.samuel.gamevault.enums.Genre;
import de.samuel.gamevault.enums.Platform;

import java.math.BigDecimal;
import java.util.List;

public record GameDTO(Long id, String name, String description, Genre genre, List<Platform> platforms, BigDecimal price, Double rating) {
}
