package com.example.projet_pfe.controllers;

import com.example.projet_pfe.entities.Configuration;
import com.example.projet_pfe.entities.Project;
import com.example.projet_pfe.servicesInterfaces.Iconfiguration;
import com.example.projet_pfe.servicesInterfaces.Iproject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {
    Iproject projectService;
    @GetMapping("/list")
    public List<Project> getAllProjects()
    {
        return projectService.getAllProjects();
    }
    @PostMapping("/addProject")
    public Project addProject(@RequestBody Project project)
    {
        return projectService.addProject(project);
    }
    @PutMapping("/updateProject/{id_project}")
    public Project updateProject(@RequestBody Project project,@PathVariable("id_project") Long id_project)
    {
        Project p = projectService.getProject(id_project);
        project.setId_project(p.getId_project());
        return projectService.updateProject(project);
    }
    @GetMapping("/getProject/{id_project}")
    public Project getProject(@PathVariable("id_project")Long id_project)
    {
        return projectService.getProject(id_project);
    }
    @DeleteMapping("/deleteProject/{id_project}")
    public void deleteProject(@PathVariable("id_project") Long id_project)
    {
        projectService.removeProject(id_project);
    }
}
