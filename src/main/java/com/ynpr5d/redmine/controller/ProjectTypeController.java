package com.ynpr5d.redmine.controller;

import com.ynpr5d.redmine.entity.ProjectType;
import com.ynpr5d.redmine.service.ProjectTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Tag(name = "Project Type Management", description = "The Project Type Management APIs")
public class ProjectTypeController {

    private final ProjectTypeService projectTypeService;

    @Autowired
    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @Operation(summary = "Get all project types")
    @GetMapping("/api/projectTypes")
    @ResponseBody
    public List<ProjectType> listProjectTypes() {
        return projectTypeService.getAllProjectTypes();
    }
}