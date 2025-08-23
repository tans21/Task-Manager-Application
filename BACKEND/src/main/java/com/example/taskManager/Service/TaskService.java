package com.example.taskManager.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskManager.Entity.TaskEntity;
import com.example.taskManager.Repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Create or Update Task
    public TaskEntity saveTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    // Get all tasks
    public Iterable<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID
    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Delete task by ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Toggle completion status
    public TaskEntity toggleTaskCompletion(Long id) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskEntity task = optionalTask.get();
            task.setIsCompleted(!Boolean.TRUE.equals(task.getIsCompleted()));
            return taskRepository.save(task);
        }
        return null; // or throw custom exception
    }
}
