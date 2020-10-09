package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.mockito.verification.VerificationMode.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.repository.SampleRepository;
import com.example.demo.repository.entity.Todo;
import com.example.demo.service.TodoService;
import com.example.demo.service.TodoServiceImpl;
import com.example.demo.service.dto.TodoDto;

@ExtendWith(MockitoExtension.class)
class SampleServiceUTTest {

	@Mock
	private SampleRepository sr;

	@InjectMocks
	private TodoServiceImpl ts;
	
	@BeforeEach
	void setup() {
		// 各テストの実行前にモックオブジェクトを初期化する
		// TODO ネットではこれが必要との記載が多いが、Extendを利用すればなくても動く
//		MockitoAnnotations.initMocks(this);
	}

	@Test
	void サービスクラスのテスト１() {
		Todo td = new Todo();
		td.setTodoId("2");
		td.setTodoTitle("朝ごはんつくる");
		td.setFinished(false);
		td.setCreatedAt(LocalDateTime.of(2020, 12, 1, 9, 15));
		Optional<Todo> value = Optional.ofNullable(td);
		when(sr.findById(2)).thenReturn(value);

		TodoDto dto = ts.findById(2);
		
		assertEquals("朝ごはんつくる", dto.getTodoTitle());
		verify(sr,never()).findById(1);
		

	}
}
