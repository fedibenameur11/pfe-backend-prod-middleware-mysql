package com.example.projet_pfe.services;

import com.example.projet_pfe.configuration.ActiveMQConfig;
import com.example.projet_pfe.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
///////////RabbitMq
    /*@Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
        System.out.println("Sent message: " + message);
    }*/

//////ActiveMQ

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(ActiveMQConfig.QUEUE_NAME, message);
        System.out.println("Sent message: " + message);
    }
}