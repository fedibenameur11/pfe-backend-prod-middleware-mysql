package com.example.projet_pfe;

import com.example.projet_pfe.entities.Project;
import com.example.projet_pfe.repositories.ProjectRepository;
import com.example.projet_pfe.services.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)

public class ProjectServiceTest {
    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    private Project project1;
    private Project project2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        project1 = new Project();
        project1.setId_project(1L);

        project2 = new Project();
        project2.setId_project(2L);
    }

    @Test
    void testGetAllConfigurations() {
        when(projectRepository.findAll()).thenReturn(Arrays.asList(project1,project2));

        List<Project> projects = projectService.getAllProjects();

        assertNotNull(projects);
        assertEquals(2, projects.size());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void testAddConfiguration() {
        when(projectRepository.save(any(Project.class))).thenReturn(project1);

        Project addedProject = projectService.addProject(project1);

        assertNotNull(addedProject);
        assertEquals(project1.getId_project(), addedProject.getId_project());
        verify(projectRepository, times(1)).save(project1);
    }

    @Test
    void testUpdateConfiguration() {
        when(projectRepository.save(any(Project.class))).thenReturn(project1);

        Project updatedProject = projectService.updateProject(project1);

        assertNotNull(updatedProject);
        assertEquals(project1.getId_project(), updatedProject.getId_project());
        verify(projectRepository, times(1)).save(project1);
    }

    @Test
    void testGetConfiguration_WhenExists() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project1));

        Project retrievedProject = projectService.getProject(1L);

        assertNotNull(retrievedProject);
        assertEquals(1L, retrievedProject.getId_project());
        verify(projectRepository, times(1)).findById(1L);
    }

    @Test
    void testGetConfiguration_WhenNotExists() {
        when(projectRepository.findById(3L)).thenReturn(Optional.empty());

        Project retrievedProject = projectService.getProject(3L);

        assertNull(retrievedProject);
        verify(projectRepository, times(1)).findById(3L);
    }

    @Test
    void testRemoveConfiguration() {
        doNothing().when(projectRepository).deleteById(1L);

        projectService.removeProject(1L);

        verify(projectRepository, times(1)).deleteById(1L);
    }
}
