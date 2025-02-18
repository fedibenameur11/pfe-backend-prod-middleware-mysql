package com.example.projet_pfe.servicesInterfaces;

import com.example.projet_pfe.entities.Project;
import com.example.projet_pfe.repositories.ProjectRepository;

import java.util.List;

public interface Iproject {
    public List<Project> getAllProjects();
    public Project addProject(Project project);
    public Project updateProject(Project project);
    public Project getProject(Long id);
    public void removeProject(Long id);
}
