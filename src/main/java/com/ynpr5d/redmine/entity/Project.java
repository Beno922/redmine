package com.ynpr5d.redmine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "type_id")
    private Integer typeId;

    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private ProjectType projectType;
}
