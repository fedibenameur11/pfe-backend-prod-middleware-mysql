package com.example.projet_pfe.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_user;
    String username;
    String email;
    String password;
    RoleType role;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "u")
    List<Configuration> configurations;

}
