package com.ynpr5d.redmine.service;

import com.ynpr5d.redmine.entity.Task;
import com.ynpr5d.redmine.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskDeadlineNotifier {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedRate = 60000) // Ellenőrzés minden percben
    public void checkTaskDeadlines() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deadlineThreshold = now.plusDays(7); // Egy héten belüli határidők

        List<Task> tasks = taskRepository.findByDeadlineBefore(deadlineThreshold);
        for (Task task : tasks) {
            messagingTemplate.convertAndSend("/topic/deadlines", "Task '" + task.getName() + "' is due soon!");
        }
    }
}
