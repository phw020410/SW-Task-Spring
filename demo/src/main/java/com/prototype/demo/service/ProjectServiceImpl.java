package com.prototype.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prototype.demo.dao.Project;
import com.prototype.demo.repo.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long idx) {
        Project project = projectRepository.findById(idx).orElse(null);
        if (project == null) {
            return null;
        }

        return project;
    }

    @Override
    public void createProject(Project project) {
        if (project.getIdx() != null && projectRepository.existsById(project.getIdx())) {
            throw new IllegalArgumentException("Project with id " + project.getIdx() + " already exists.");
        }
        
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void updateProject(Long idx, Project project) {
        Project existingProject = projectRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with id: " + idx));
        
        // Update fields
        existingProject.setUsername(project.getUsername());
        existingProject.setAuthor(project.getAuthor());
        existingProject.setContent(project.getContent());

        projectRepository.save(existingProject);
    }

    @Override
    public void deleteProject(Long idx) {
        if (!projectRepository.existsById(idx)) {
            throw new IllegalArgumentException("Project not found with id: " + idx);
        }

        projectRepository.deleteById(idx);
    }
    
}
