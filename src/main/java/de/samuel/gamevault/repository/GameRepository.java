package de.samuel.gamevault.repository;

import de.samuel.gamevault.enums.Platform;
import de.samuel.gamevault.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {

    List<GameModel> findByPlatformsIn(List<Platform> platforms);

}
