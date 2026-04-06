package de.samuel.gamevault.repository;

import de.samuel.gamevault.model.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
}
