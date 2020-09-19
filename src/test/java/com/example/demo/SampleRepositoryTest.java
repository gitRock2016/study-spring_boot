package com.example.demo;

import java.util.Optional;

import org.dbunit.Assertion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.SampleRepository;
import com.example.demo.repository.entity.Todo;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@TestExecutionListeners({
		// TODO 依存に出てこない
//      DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
//@SpringBootTest(classes = { DemoApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@SpringBootTest(classes = DemoApplication.class)
@MybatisTest
public class SampleRepositoryTest {

	@Autowired
	private SampleRepository repo;
	
//	public SampleRepositoryTest(Repository repo) {
//		this.repo = repo;
//	}

	@Test
	@DatabaseSetup(value = "/testdb/")
	@Transactional
	public void contextLoads() throws Exception {
		Optional<Todo> todo = repo.findById(1);
		Assertions.assertEquals(todo.get().getTodoTitle(), "夜ごはんつくる");

	}
}
