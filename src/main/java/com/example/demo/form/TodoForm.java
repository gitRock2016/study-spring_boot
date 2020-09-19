package com.example.demo.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TodoForm {
	private String todoId;
	private String todoTitle;
	private boolean finished;
	private LocalDateTime createdAt;

}
