package com.example.projet_pfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/deploy")
public class DeploymentController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/trigger")
    public ResponseEntity<String> triggerJenkinsJob() {
        // Include the token in the Jenkins webhook URL
        String jenkinsUrl = "http://192.168.37.128:8080/generic-webhook-trigger/invoke?token=springboot-token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(jenkinsUrl, HttpMethod.POST, entity, String.class);
            return ResponseEntity.ok("Déploiement déclenché : " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace(); // Affiche l'erreur complète dans les logs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors du déclenchement : " + e.getMessage());
        }
    }
}