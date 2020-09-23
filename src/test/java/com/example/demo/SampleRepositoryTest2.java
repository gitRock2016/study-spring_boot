package com.example.demo;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.SampleRepository;
import com.example.demo.repository.entity.Todo;

@SpringBootTest(classes = SampleRepositoryTest2.class)
@MybatisTest
public class SampleRepositoryTest2 {

	@Autowired
	private SampleRepository repo;
	
	@Test
	public void contextLoads() throws Exception {
		Optional<Todo> todo = repo.findById(1);
		Assertions.assertEquals(todo.get().getTodoTitle(), "夜ごはんつくる");

	}
}
