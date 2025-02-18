package com.example.projet_pfe.services;

import com.example.projet_pfe.entities.Project;
import com.example.projet_pfe.repositories.ProjectRepository;
import com.example.projet_pfe.servicesInterfaces.Iproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements Iproject {
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void removeProject(Long id) {
        projectRepository.deleteById(id);
    }
}
