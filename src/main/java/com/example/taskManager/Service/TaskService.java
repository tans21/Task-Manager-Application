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
	
	public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public Optional<TaskEntity> getTask(Integer id) {
        return taskRepository.findById(id);
    }

    public Iterable<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> updateTask(TaskEntity task) {
        if (!taskRepository.existsById(task.getId())) {
            return Optional.empty(); 
        }
        return Optional.of(taskRepository.save(task));
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

}

