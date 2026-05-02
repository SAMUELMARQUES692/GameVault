package de.samuel.gamevault.model;

import de.samuel.gamevault.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String emailFrom;
    private String emailTo;
    private String emailSubject;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime sentAt;
    private EmailStatus statusEmail;

}
