package com.ynpr5d.redmine.service;

import com.ynpr5d.redmine.entity.Project;
import com.ynpr5d.redmine.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

     public Optional<Project> getProjectById(Integer projectId) {
        return projectRepository.findById(Long.valueOf(projectId));
    }

}
