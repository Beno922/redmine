package com.ynpr5d.redmine.controller;

import com.ynpr5d.redmine.entity.Task;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/notify")
    @SendTo("/topic/notifications")
    public Task sendNotification(Task task) {
        // Add log to check if this method is invoked
        System.out.println("Received task: " + task.getName());
        return task;
    }
}
