package com.example.taskManager.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Title is required")
	private String title;

	@NotNull(message = "Due date is required")
	private Date DueDate;

	private Boolean isCompleted;

	protected TaskEntity() {

	}

	public TaskEntity(String title, Date DueDate, Boolean isCompleted) {
		super();
		this.title = title;
		this.DueDate = DueDate;
		this.isCompleted = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDueDate() {
		return DueDate;
	}

	public void setDueDate(Date dueDate) {
		this.DueDate = dueDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "TaskEntity [id=" + id + ", title=" + title + ", DueDate=" + DueDate + ", isCompleted=" + isCompleted + "]";
	}
}