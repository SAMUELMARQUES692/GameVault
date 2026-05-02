package de.samuel.gamevault.config.Rabbit;

import de.samuel.gamevault.dto.EmailDTO;
import de.samuel.gamevault.model.EmailModel;
import de.samuel.gamevault.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "email-queue-gamevault")
    public void listenEmailQueue(@Payload EmailDTO emailDTO) {
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);
    }

}
