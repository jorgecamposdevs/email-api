package com.ms.email.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")
    private String queue;

    @Value("${spring.rabbitmq.address}")
    private String address;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        var cf = new CachingConnectionFactory();
        cf.setUri(address);
        return cf;
    }
}