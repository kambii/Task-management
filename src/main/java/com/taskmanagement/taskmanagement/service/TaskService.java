package com.taskmanagement.taskmanagement.service;

import com.taskmanagement.taskmanagement.entity.Task;
import com.taskmanagement.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public Task createTask(Task task) {
        task.setCreated(LocalDateTime.now());
        return taskRepository.save(task);
    }


    public Task updateTask(Long id, Task task) {
        task.setCreated(LocalDateTime.now());

        Task currentTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("task not found with id: " + id));

        currentTask.setName(task.getName());
        currentTask.setDescription(task.getDescription());

        return taskRepository.save(currentTask);
    }

    public void deleteTask(Long id) {
        Task currentTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("task not found with id: " + id));

        taskRepository.delete(currentTask);
    }
}
