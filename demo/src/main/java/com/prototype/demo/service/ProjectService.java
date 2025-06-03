package com.prototype.demo.service;

import java.util.List;

import com.prototype.demo.dao.Project;

public interface ProjectService {
    List<Project> getAllProject();
    Project getProjectById(Long idx);
    void createProject(Project project);
    void updateProject(Long idx, Project project);
    void deleteProject(Long idx);
}
