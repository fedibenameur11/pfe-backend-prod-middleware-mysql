package com.example.projet_pfe.repositories;

import com.example.projet_pfe.entities.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration,Long> {
}
