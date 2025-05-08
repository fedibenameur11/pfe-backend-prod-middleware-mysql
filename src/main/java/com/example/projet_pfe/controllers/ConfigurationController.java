package com.example.projet_pfe.controllers;

import com.example.projet_pfe.entities.Configuration;
import com.example.projet_pfe.entities.User;
import com.example.projet_pfe.servicesInterfaces.Iconfiguration;
import com.example.projet_pfe.servicesInterfaces.Iuser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/configuration")
public class ConfigurationController {
    Iconfiguration configurationService;
    @GetMapping("/list")
    public List<Configuration> getAllConfigurations()
    {
        return configurationService.getAllConfigurations();
    }
    @PostMapping("/addConfiguration")
    public Configuration addConfiguration(@RequestBody Configuration configuration)
    {
        return configurationService.addConfiguration(configuration);
    }
    @PutMapping("/updateConfiguration/{id_config}")
    public Configuration updateConfiguration(@RequestBody Configuration configuration,@PathVariable("id_config") Long id_config)
    {
        Configuration c = configurationService.getConfiguration(id_config);
        configuration.setId_config(c.getId_config());
        return configurationService.updateConfiguration(configuration);
    }
    @GetMapping("/getConfiguration/{id_config}")
    public Configuration getConfiguration(@PathVariable("id_config")Long id_config)
    {
        return configurationService.getConfiguration(id_config);
    }
    @DeleteMapping("/deleteConfiguration/{id_config}")
    public void deleteConfiguration(@PathVariable("id_config") Long id_config)
    {
        configurationService.removeConfiguration(id_config);
    }
}
