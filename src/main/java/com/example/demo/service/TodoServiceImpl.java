package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.repository.SampleRepository;
import com.example.demo.repository.entity.Todo;
import com.example.demo.service.dto.TodoDto;

@Service
public class TodoServiceImpl implements TodoService {
	
	private final SampleRepository sr;
	
	public TodoServiceImpl(SampleRepository sr) {
		this.sr = sr;
	}

	@Override
	public List<TodoDto> findUnfinishedTask(TodoDto dto) throws SampleEmptyResultException {
		List<Todo> todos=sr.findByFinished(false);
		if (StringUtils.isEmpty(todos)) throw new SampleEmptyResultException();
		List<TodoDto> arraylist = new ArrayList<TodoDto>();
		for(Todo td : todos) {
			TodoDto todoDto = beanmapper(td);
			arraylist.add(todoDto);
		}
		
		return arraylist;
	}

	@Override
	public TodoDto findById(Integer id) {
		Todo td = sr.findById(id).get();
		
		
		return beanmapper(td);
	}
	
	private TodoDto beanmapper(Todo td) {
		TodoDto todoDto = new TodoDto();
		todoDto.setTodoId(td.getTodoId());
		todoDto.setTodoTitle(td.getTodoTitle());
		todoDto.setFinished(td.isFinished());
		todoDto.setCreatedAt(td.getCreatedAt());
		return todoDto;
	}
}
