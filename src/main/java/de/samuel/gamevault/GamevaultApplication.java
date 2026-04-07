package de.samuel.gamevault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class GamevaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamevaultApplication.class, args);
	}

}
