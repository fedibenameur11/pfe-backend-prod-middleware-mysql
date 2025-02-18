package com.example.projet_pfe.services;

import com.example.projet_pfe.entities.User;
import com.example.projet_pfe.repositories.UserRepository;
import com.example.projet_pfe.servicesInterfaces.Iuser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements Iuser {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    public User addUser(User user)
    {
        return userRepository.save(user);
    }
    public User updateUser(User user)
    {
        return userRepository.save(user);
    }
    public User getUser(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }
    public void removeUser(Long id)
    {
        userRepository.deleteById(id);
    }
}
