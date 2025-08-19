package com.example.taskManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskManager.Entity.TaskEntity;
import com.example.taskManager.Service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/addTask")
	public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity task) {
		return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
	}

	@GetMapping(value = "get/{id}")
	public ResponseEntity<TaskEntity> getTask(@PathVariable Long id) {
		return taskService.getTask(id).map(task -> new ResponseEntity<>(task, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public Iterable<TaskEntity> getAllTasks() {
		return taskService.getAllTasks();
	}

	@PutMapping(value = "/updateTask")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity task) {
        return taskService.updateTask(task)
            .map(updatedTask -> new ResponseEntity<>(updatedTask, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	@DeleteMapping(value = "/deleteTask/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		 taskService.deleteTask(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

}
