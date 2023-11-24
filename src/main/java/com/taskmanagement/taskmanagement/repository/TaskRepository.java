package com.taskmanagement.taskmanagement.repository;

import com.taskmanagement.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
