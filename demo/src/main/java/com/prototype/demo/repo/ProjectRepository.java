package com.prototype.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.demo.dao.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{}
