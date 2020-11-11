package com.example.demo.service.dto;

import java.time.LocalDateTime;

import com.example.demo.repository.entity.Todo;

import lombok.Data;
@Data
public class TodoDto {
	private String todoId;
	private String todoTitle;
	private boolean finished;
	private LocalDateTime createdAt;
}
