package com.example.demo.repository.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Todo {
	private String todoId;
	private String todoTitle;
	private boolean finished;
	private LocalDateTime createdAt;

}
