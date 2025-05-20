package com.example.projet_pfe.services;

import com.example.projet_pfe.configuration.ActiveMQConfig;
import com.example.projet_pfe.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.projet_pfe.configuration.NatsConfig;
import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MessageConsumer {
//////RabbitMQ
    /*@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Add business logic, e.g., save to PostgreSQL or process the message
    }*/
//////ActiveMQ

    /*@JmsListener(destination = ActiveMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Logique métier ici
    }*/

//////////NATS
@Autowired
private Connection natsConnection;

    @PostConstruct
    public void init() {
        Dispatcher dispatcher = natsConnection.createDispatcher((msg) -> {
            String receivedMessage = new String(msg.getData());
            System.out.println("Received message: " + receivedMessage);
            // Logique métier ici
        });
        dispatcher.subscribe(NatsConfig.SUBJECT_NAME);
    }


}
