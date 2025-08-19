package com.example.taskManager.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.taskManager.Entity.TaskEntity;


public interface TaskRepository extends CrudRepository<TaskEntity, Long>{

	
}

