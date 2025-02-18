package com.example.projet_pfe.servicesInterfaces;

import com.example.projet_pfe.entities.Configuration;
import com.example.projet_pfe.entities.User;

import java.util.List;

public interface Iconfiguration {
    public List<Configuration> getAllConfigurations();
    public Configuration addConfiguration(Configuration configuration);
    public Configuration updateConfiguration(Configuration configuration);
    public Configuration getConfiguration(Long id);
    public void removeConfiguration(Long id);
}
