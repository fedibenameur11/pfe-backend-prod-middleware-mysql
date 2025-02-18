package com.example.projet_pfe.servicesInterfaces;

import com.example.projet_pfe.entities.User;

import java.util.List;

public interface Iuser {
    public List<User> getAllUsers();
    public User addUser(User user);
    public User updateUser(User user);
    public User getUser(Long id);
    public void removeUser(Long id);

}
