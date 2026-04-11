package de.samuel.gamevault.exception;

import de.samuel.gamevault.enums.Platform;

public class PlatformNotFoundException extends RuntimeException{

    public PlatformNotFoundException(Platform platform) {
        super("Plataforma " + platform + " não há cadastro no banco de dados");
    }
}
