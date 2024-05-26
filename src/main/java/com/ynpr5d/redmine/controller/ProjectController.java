package com.ynpr5d.redmine.controller;

import com.ynpr5d.redmine.entity.Project;
import com.ynpr5d.redmine.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Tag(name = "Project Management System", description = "The Project Management APIs")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Welcome message for the home API")
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to the home API";
    }

    @Operation(summary = "Get all projects")
    @GetMapping("/api/projects")
    @ResponseBody
    public List<Project> listProjects() {
        return projectService.getAllProjects();
    }

    @Operation(summary = "Get a project by ID")
    @GetMapping("/api/projects/{projectId}")
    @ResponseBody
    public String getProjectById(
            @Parameter(description = "ID of the project to be retrieved", required = true)
            @PathVariable Integer projectId) {
        return "Project details for project ID: " + projectId; // Placeholder text
    }

    @Operation(summary = "Get all tasks")
    @GetMapping("/api/tasks")
    public String listTasks(@RequestParam(name="name", required=false, defaultValue="Task") String name, Model model) {
        model.addAttribute("name", name);
        return "tasks";  // Returns the tasks.html template
    }

    @Operation(summary = "Add a task to a project")
    @PostMapping("/api/projects/{projectId}/tasks")
    @ResponseBody
    public String addTaskToProject(
            @Parameter(description = "ID of the project to add the task to", required = true)
            @PathVariable Integer projectId,
            @RequestBody String task) {
        return "Task added to project ID: " + projectId; // Placeholder text
    }
}