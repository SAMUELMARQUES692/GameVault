package de.samuel.gamevault.dto;

import lombok.Data;

@Data
public class EmailDTO {

    private Long userId;
    private String emailTo;
    private String emailSubject;
    private String body;
}

