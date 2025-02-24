package com.example.projet_pfe.services;

import com.example.projet_pfe.entities.User;
import com.example.projet_pfe.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    /*private final UserRepository userRepository;

    @Value("${keycloak.server-url}")
    private String keycloakServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Value("${keycloak.username}")
    private String adminUsername;

    @Value("${keycloak.password}")
    private String adminPassword;

    private Keycloak getKeycloakInstance() {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakServerUrl)
                .realm("master")  // Utiliser "master" pour authentification admin
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username(adminUsername)
                .password(adminPassword)
                .grantType(OAuth2Constants.PASSWORD)
                .build();
    }

    public List<User> fetchAndStoreUsers() {
        Keycloak keycloak = getKeycloakInstance();
        UsersResource usersResource = keycloak.realm(realm).users();

        List<UserRepresentation> keycloakUsers = usersResource.list();

        List<User> users = keycloakUsers.stream().map(ku -> {
            User user = new User();
            user.setUsername(ku.getUsername());
            user.setEmail(ku.getEmail());
            user.setPassword("default-password"); // Keycloak ne retourne pas le password
            return user;
        }).collect(Collectors.toList());

        return userRepository.saveAll(users);
    }*/
}
