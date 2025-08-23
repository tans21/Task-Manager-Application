package com.example.taskManager.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.taskManager.Entity.TaskEntity;
import com.example.taskManager.Service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/todo")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Add task
    @PostMapping
    public ResponseEntity<TaskEntity> create(@Valid @RequestBody TaskEntity task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<Iterable<TaskEntity>> readAll() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // Toggle Complete (isComplete)
    @PutMapping("/{id}/toggle-complete")
    public ResponseEntity<TaskEntity> toggleComplete(@PathVariable long id) {
        return ResponseEntity.ok(taskService.toggleTaskCompletion(id));
    }

    // Update task (just saving again works as update)
    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> update(@PathVariable long id,
                                             @Valid @RequestBody TaskEntity updatedTask) {
        updatedTask.setId(id); // ensure the ID is set
        return ResponseEntity.ok(taskService.saveTask(updatedTask));
    }

    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
