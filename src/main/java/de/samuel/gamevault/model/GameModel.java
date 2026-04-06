package de.samuel.gamevault.model;

import de.samuel.gamevault.enums.Platform;
import de.samuel.gamevault.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 250)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private Genre genre;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "game_platforms", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "platform", length = 50)
    private List<Platform> platforms;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Double rating;

    @ManyToMany(mappedBy = "games")
    private List<LibraryModel> libraries;

}
