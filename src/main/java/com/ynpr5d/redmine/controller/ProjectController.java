package com.ynpr5d.redmine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Tag(name = "Project Management System", description = "The Project Management APIs")
public class ProjectController {

    @Operation(summary = "Welcome message for the home API")
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to the home API";
    }

    @Operation(summary = "Get all projects")
    @GetMapping("/api/projects")
    public String listProjects(@RequestParam(name="name", required=false, defaultValue="Project") String name, Model model) {
        model.addAttribute("name", name);
        return "projects";  // Returns the projects.html template
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
