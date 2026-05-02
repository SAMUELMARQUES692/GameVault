package de.samuel.gamevault.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQ {

    private final String queueName = "email-queue-gamevault";

    @Bean
    public Queue emailQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new JacksonJsonMessageConverter();
    }

}
