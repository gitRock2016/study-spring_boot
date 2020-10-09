package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.demo.repository.SampleRepository;
import com.example.demo.repository.entity.Todo;
import com.example.demo.service.TodoServiceImpl;
import com.example.demo.service.dto.TodoDto;


//@AutoConfigureMockMvc
class SampleServiceUTest {
	
	@Mock
	private SampleRepository sr;
	
	@InjectMocks
	private TodoServiceImpl ts;

	@Test
	void サービスクラスのテスト１() {
//		 MockitoAnnotations.initMocks(this);
		Todo td = new Todo();
		td.setTodoId("1");
		td.setTodoTitle("朝ごはんつくる");
		td.setFinished(false);
		td.setCreatedAt(LocalDateTime.of(2020, 12, 1, 9, 15));
		Optional<Todo> value =Optional.ofNullable(td); 
		Mockito.when(sr.findById(1)).thenReturn(value );
		
		TodoDto dto = ts.findById(1);
		assertEquals("朝ごはんつくる", dto.getTodoTitle());
		
	}
			
		
//		return beanmapper(td);
//	
//	private TodoDto beanmapper(Todo td) {
//		TodoDto todoDto = new TodoDto();
//		todoDto.setTodoId(td.getTodoId());
//		todoDto.setTodoTitle(td.getTodoTitle());
//		todoDto.setFinished(td.isFinished());
//		todoDto.setCreatedAt(td.getCreatedAt());
//		return todoDto;
//	}

}
