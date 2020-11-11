package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.SampleRepository;
import com.example.demo.repository.entity.Todo;

@MybatisTest
class SampleRepositoryITest {

	@Autowired
	private SampleRepository repo;

	@Test
	public void test_findById_001() throws Exception {

		Optional<Todo> todo = repo.findById(1);
		assertEquals("朝ごはんつくる", todo.get().getTodoTitle());

	}

	@Test
	public void test_findById_002() throws Exception {
		Optional<Todo> todo = repo.findById(2);
		assertEquals("夜ごはんつくる", todo.get().getTodoTitle());

	}

}
