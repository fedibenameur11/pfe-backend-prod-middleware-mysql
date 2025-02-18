package com.example.projet_pfe.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Configuration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_config;
    String name;
    @Enumerated(EnumType.STRING)
    DatabaseType databaseType;
    @Enumerated(EnumType.STRING)
    MiddlewareType middleware;
    @Enumerated(EnumType.STRING)
    DeployementType deployment;
    @Enumerated(EnumType.STRING)
    AuthenticationType authentication;
    @Enumerated(EnumType.STRING)
    MonitoringType monitoring;

    @ManyToOne(cascade = CascadeType.ALL)
    User u;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "c")
    Project p;


}
