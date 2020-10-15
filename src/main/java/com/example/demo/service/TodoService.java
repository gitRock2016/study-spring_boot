package com.example.demo.service;

import java.util.List;

import com.example.demo.service.dto.TodoDto;

public interface TodoService {
	List<TodoDto> findUnfinishedTask(TodoDto dto) throws SampleEmptyResultException;
	
	TodoDto findById(Integer id);
}
