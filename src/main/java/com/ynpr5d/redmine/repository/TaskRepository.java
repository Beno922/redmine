package com.ynpr5d.redmine.repository;

import com.ynpr5d.redmine.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByDeadlineBefore(LocalDateTime deadline);
}
