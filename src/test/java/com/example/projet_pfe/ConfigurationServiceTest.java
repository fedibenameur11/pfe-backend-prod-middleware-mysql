package com.example.projet_pfe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.projet_pfe.entities.Configuration;
import com.example.projet_pfe.repositories.ConfigurationRepository;
import com.example.projet_pfe.services.ConfigurationService;

@ExtendWith(MockitoExtension.class)
 class ConfigurationServiceTest {

    @Mock
    private ConfigurationRepository configurationRepository;

    @InjectMocks
    private ConfigurationService configurationService;

    private Configuration config1;
    private Configuration config2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        config1 = new Configuration();
        config1.setId_config(1L);
        config1.setName("Config 1");

        config2 = new Configuration();
        config2.setId_config(2L);
        config2.setName("Config 2");
    }

    @Test
    void testGetAllConfigurations() {
        when(configurationRepository.findAll()).thenReturn(Arrays.asList(config1, config2));

        List<Configuration> configurations = configurationService.getAllConfigurations();

        assertNotNull(configurations);
        assertEquals(2, configurations.size());
        verify(configurationRepository, times(1)).findAll();
    }

    @Test
    void testAddConfiguration() {
        when(configurationRepository.save(any(Configuration.class))).thenReturn(config1);

        Configuration addedConfig = configurationService.addConfiguration(config1);

        assertNotNull(addedConfig);
        assertEquals(config1.getId_config(), addedConfig.getId_config());
        verify(configurationRepository, times(1)).save(config1);
    }

    @Test
    void testUpdateConfiguration() {
        when(configurationRepository.save(any(Configuration.class))).thenReturn(config1);

        Configuration updatedConfig = configurationService.updateConfiguration(config1);

        assertNotNull(updatedConfig);
        assertEquals(config1.getId_config(), updatedConfig.getId_config());
        verify(configurationRepository, times(1)).save(config1);
    }

    @Test
    void testGetConfiguration_WhenExists() {
        when(configurationRepository.findById(1L)).thenReturn(Optional.of(config1));

        Configuration retrievedConfig = configurationService.getConfiguration(1L);

        assertNotNull(retrievedConfig);
        assertEquals(1L, retrievedConfig.getId_config());
        verify(configurationRepository, times(1)).findById(1L);
    }

    @Test
    void testGetConfiguration_WhenNotExists() {
        when(configurationRepository.findById(3L)).thenReturn(Optional.empty());

        Configuration retrievedConfig = configurationService.getConfiguration(3L);

        assertNull(retrievedConfig);
        verify(configurationRepository, times(1)).findById(3L);
    }

    @Test
    void testRemoveConfiguration() {
        doNothing().when(configurationRepository).deleteById(1L);

        configurationService.removeConfiguration(1L);

        verify(configurationRepository, times(1)).deleteById(1L);
    }
}