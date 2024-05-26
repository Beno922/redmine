package com.ynpr5d.redmine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "project_developers")
public class ProjectDeveloper {
    @EmbeddedId
    private ProjectDeveloperId id;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @MapsId("developerId")
    @JoinColumn(name = "developer_id")
    private Developer developer;
}

@Embeddable
class ProjectDeveloperId implements Serializable {
    private Integer projectId;
    private Integer developerId;
}
