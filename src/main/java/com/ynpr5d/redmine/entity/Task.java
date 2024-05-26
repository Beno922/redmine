package com.ynpr5d.redmine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "user_id")
    private Integer userId;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Manager manager;
}
