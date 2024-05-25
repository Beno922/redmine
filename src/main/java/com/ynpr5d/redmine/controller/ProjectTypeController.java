package com.ynpr5d.redmine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Tag(name = "Project Type Management", description = "The Project Type Management APIs")
public class ProjectTypeController {

    @Operation(summary = "Get all project types")
    @GetMapping("/api/projectTypes")
    @ResponseBody
    public ResponseEntity<List<Object>> listProjectTypes() {
        // Logic to retrieve and return all project types
        return ResponseEntity.ok().body(/* list of project types */ null);
    }
}
