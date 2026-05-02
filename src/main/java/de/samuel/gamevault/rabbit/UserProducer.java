package de.samuel.gamevault.rabbit;

import de.samuel.gamevault.dto.EmailDTO;
import de.samuel.gamevault.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    private final String routingKey = "email-queue-gamevault";

    public void publishEvent(UserModel userModel) {
        var emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setEmailSubject("Welcome developers");
        emailDTO.setBody("Hello " + userModel.getName() + ",\n\nWelcome, developers! We are excited for you to test our functionalities.");

        rabbitTemplate.convertAndSend(
                "",
                routingKey,
                emailDTO);
    }

    public void publishUpdate(UserModel userModel) {
        var emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setEmailSubject("Informations Updated!!");
        emailDTO.setBody("Hello " + userModel.getName() + ",\n\nYour information has been updated successfully, developers! We are excited for you to continue testing our functionalities.");

        rabbitTemplate.convertAndSend(
                "",
                routingKey,
                emailDTO);
    }

    public void publishDelete(UserModel userModel) {
        var emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setEmailSubject("Goodbye developers");
        emailDTO.setBody("Hello " + userModel.getName() + ",\n\nWe are sorry to see you go, developers! We hope you had a great experience testing our functionalities.");

        rabbitTemplate.convertAndSend(
                "",
                routingKey,
                emailDTO);
    }

}
