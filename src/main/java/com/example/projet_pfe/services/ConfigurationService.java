package com.example.projet_pfe.services;

import com.example.projet_pfe.entities.Configuration;
import com.example.projet_pfe.repositories.ConfigurationRepository;
import com.example.projet_pfe.servicesInterfaces.Iconfiguration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConfigurationService implements Iconfiguration {
    @Autowired
    ConfigurationRepository configurationRepository;
    public List<Configuration> getAllConfigurations()
    {
        return configurationRepository.findAll();
    }
    public Configuration addConfiguration(Configuration configuration)
    {
        return configurationRepository.save(configuration);
    }
    public Configuration updateConfiguration(Configuration configuration)
    {
        return configurationRepository.save(configuration);
    }
    public Configuration getConfiguration(Long id)
    {
        return configurationRepository.findById(id).orElse(null);
    }
    public void removeConfiguration(Long id)
    {
        configurationRepository.deleteById(id);
    }
}
