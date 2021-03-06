package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.repository.entity.Todo;

@Mapper
public interface SampleRepository {
	@Select("select todo_id, todo_title, finished, created_at from todo where todo_id = #{id}")
	Optional<Todo> findById(Integer id);
	
	@Select("select todo_id, todo_title, finished, created_at from todo ")
	List<Todo> findAll();
	
	@Select("SELECT COUNT(*) FROM todo WHERE finished = #{finished}")
	long countByFinished(boolean finished);

	@Select("SELECT * FROM todo WHERE finished = #{finished}")
	List<Todo> findByFinished(boolean finished);

	@Insert("insert into todo ( todo_id, todo_title, finished, created_at ) values (#{todoId},#{todoTitle}, #{finished}, #{created_at})")
	void insert(Todo todo);
}
