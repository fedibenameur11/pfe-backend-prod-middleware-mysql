package com.example.projet_pfe.configuration;

import com.ibm.mq.jakarta.jms.MQQueueConnectionFactory;
import jakarta.jms.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;


@Configuration
@EnableJms
public class IbmMqConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        try {
            factory.setHostName("192.168.37.129"); // Adresse IP du serveur IBM MQ
            factory.setPort(1414); // Port par défaut d'IBM MQ
            factory.setQueueManager("QM1"); // Nom du gestionnaire de files d'attente
            factory.setChannel("DEV.APP.SVRCONN"); // Canal de connexion
            factory.setTransportType(1); // 1 = TCP/IP
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la configuration de la ConnectionFactory IBM MQ", e);
        }
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1"); // Nombre de consommateurs concurrents
        return factory;
    }
}