package com.ynpr5d.redmine.controller;

import com.ynpr5d.redmine.entity.Project;
import com.ynpr5d.redmine.entity.Task;
import com.ynpr5d.redmine.service.ProjectService;
import com.ynpr5d.redmine.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Tag(name = "Project Management System", description = "The Project Management APIs")
public class ProjectController {

    private final ProjectService projectService;
    private final TaskService taskService;

    @Autowired
    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Operation(summary = "Welcome message for the home API")
    @GetMapping("/api/home")
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
    public ResponseEntity<Project> getProjectById(
            @Parameter(description = "ID of the project to be retrieved", required = true)
            @PathVariable Integer projectId) {
        Optional<Project> project = projectService.getProjectById(projectId);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all tasks")
    @GetMapping("/api/tasks")
    @ResponseBody
    public List<Task> listTasks(){
        return taskService.getAllTasks();
    }

@PostMapping("/api/projects/{projectId}/tasks")
@ResponseBody
public ResponseEntity<String> addTaskToProject(
        @Parameter(description = "ID of the project to add the task to", required = true)
        @PathVariable Integer projectId,
        @RequestBody Task task) {

    Optional<Project> project = projectService.getProjectById(projectId);
    if (project.isEmpty()) {
        return ResponseEntity.notFound().build();
    }


    task.setId(0);

    task.setProject(project.get());
    taskService.saveTask(task);

    return ResponseEntity.ok("Task added to project ID: " + projectId);
}
}