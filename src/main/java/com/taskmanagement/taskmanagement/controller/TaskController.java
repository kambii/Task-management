package com.taskmanagement.taskmanagement.controller;


import com.taskmanagement.taskmanagement.entity.Task;
import com.taskmanagement.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    private final TaskService taskservice;

    @Autowired
    public TaskController(TaskService taskservice) {
        this.taskservice = taskservice;
    }

    @GetMapping("/getTasks")
    public List<Task> getAllTasks(){
        return taskservice.getAllTasks();
    }

    @GetMapping("/getTask{id}")
    public Task getTask(@PathVariable Long id) {
        return taskservice.getTask(id);
    }

    @PostMapping("/addTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createTask = taskservice.createTask(task);
        return ResponseEntity.ok(createTask);
    }

    @PutMapping("/updateTask{id}")
    public ResponseEntity updateTask(@PathVariable Long id, @RequestBody Task task){
        Task updatedTask = taskservice.updateTask(id,task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/deleteTask{id}")
    public ResponseEntity deleteTask(@PathVariable Long id){
        taskservice.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
