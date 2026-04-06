package de.samuel.gamevault.repository;

import de.samuel.gamevault.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
}
