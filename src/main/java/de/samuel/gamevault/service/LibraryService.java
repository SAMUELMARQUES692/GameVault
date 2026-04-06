package de.samuel.gamevault.service;

import de.samuel.gamevault.dto.LibraryDTO;
import de.samuel.gamevault.exception.LibraryNotFoundException;
import de.samuel.gamevault.mapper.LibraryMapper;
import de.samuel.gamevault.model.LibraryModel;
import de.samuel.gamevault.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public LibraryDTO saveLibrary(LibraryDTO libraryDTO) {
        return libraryMapper.map(libraryRepository.save(libraryMapper.map(libraryDTO)));
    }

    public List<LibraryDTO> getAll() {
        return libraryRepository.findAll().stream()
                .map(libraryMapper::map)
                .toList();
    }

    public LibraryDTO findById(Long id) {
        return libraryRepository.findById(id)
                .map(libraryMapper::map)
                .orElseThrow(() -> new LibraryNotFoundException(id));
    }

    public LibraryDTO updateById(Long id, LibraryDTO libraryDTO) {
        libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException(id));

        LibraryModel updateLibrary = libraryMapper.map(libraryDTO);
        updateLibrary.setId(id);

        return libraryMapper.map(libraryRepository.save(updateLibrary));
    }

    public void deleteById(Long id) {
       LibraryModel library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException(id));
       libraryRepository.delete(library);
    }


}
