package de.samuel.gamevault.exception;

public class LibraryNotFoundException extends RuntimeException{

    public LibraryNotFoundException(Long id) {
        super("Library not found with id: " + id);
    }
}
