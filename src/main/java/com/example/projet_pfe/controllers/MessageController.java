package com.example.projet_pfe.controllers;

import com.example.projet_pfe.services.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody String message) {
        messageProducer.sendMessage(message);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Message sent: " + message);
        return ResponseEntity.ok(response);
    }
}