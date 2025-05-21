package com.example.projet_pfe.configuration;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NatsConfig {

    /*public static final String SUBJECT_NAME = "mySubject";

    @Bean
    public Connection natsConnection() throws Exception {
        Options options = new Options.Builder()
                .server("nats://192.168.37.129:4222") // Remplacez par l'URL de votre serveur NATS
                .build();
        return Nats.connect(options);
    }*/
}