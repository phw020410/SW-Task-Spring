package com.prototype.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.demo.dao.Project;
import com.prototype.demo.service.ProjectService;
import com.prototype.demo.service.ProjectServiceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService, ProjectServiceImpl projectServiceImpl) {
        this.projectService = projectService;
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProject() {
        List<Project> projects = projectService.getAllProject();
        if (projects.isEmpty()) {
            return ResponseEntity.status(404).body("No projects found.");
        }

        return ResponseEntity.ok(projects);
    }
    
    @GetMapping("/{idx}")
    public ResponseEntity<?> getProjectById(@PathVariable Long idx) {
        Project project = projectService.getProjectById(idx);
        if (project == null) {
            return ResponseEntity.status(404).body("Project not found.");
        }

        return ResponseEntity.ok(project);
    }

    @PostMapping("")
    public ResponseEntity<?> postMethodName(Project project) {
        if (projectServiceImpl.getProjectById(project.getIdx()) != null) {
            return ResponseEntity.status(409).body("Project with this ID already exists.");
        }
        projectService.createProject(project);
        
        return ResponseEntity.ok("200 OK");
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putMethodName(@PathVariable String idx, Project project) {
        if (projectServiceImpl.getProjectById(Long.parseLong(idx)) == null) {
            return ResponseEntity.status(404).body("Project not found.");
        }

        projectService.updateProject(Long.parseLong(idx), project);

        return ResponseEntity.ok("200 OK");
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteMethodName(@PathVariable String idx) {
        if (projectServiceImpl.getProjectById(Long.parseLong(idx)) == null) {
            return ResponseEntity.status(404).body("Project not found.");
        }

        projectService.deleteProject(Long.parseLong(idx));

        return ResponseEntity.ok("200 OK");
    }
}