package com.example.projet_pfe.controllers;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class TestController {

    @GetMapping("/test")
    public String testKeycloak(@AuthenticationPrincipal Jwt jwt) {
        return "Hello, " + jwt.getClaim("preferred_username") + "! Your token is valid.";
    }
}