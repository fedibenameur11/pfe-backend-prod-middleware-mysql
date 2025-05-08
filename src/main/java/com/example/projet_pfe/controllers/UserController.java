package com.example.projet_pfe.controllers;

import com.example.projet_pfe.entities.User;
import com.example.projet_pfe.services.KeycloakService;
import com.example.projet_pfe.servicesInterfaces.Iuser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    Iuser userService;
    KeycloakService keycloakService;
    @GetMapping("/list")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    @PutMapping("/updateUser/{id_user}")
    public User updateUser(@RequestBody User user,@PathVariable("id_user") Long id_user)
    {
        User u = userService.getUser(id_user);
        user.setId_user(u.getId_user());
        return userService.updateUser(user);
    }
    @GetMapping("/getUser/{id_user}")
    public User getUser(@PathVariable("id_user")Long id_user)
    {
        return userService.getUser(id_user);
    }
    @DeleteMapping("/deleteUser/{id_user}")
    public void deleteUser(@PathVariable("id_user") Long id_user)
    {
        userService.removeUser(id_user);
    }
    /*
    @GetMapping("/sync-users")
    public List<User> syncUsersFromKeycloak() {
        return keycloakService.fetchAndStoreUsers();
    }*/

}
