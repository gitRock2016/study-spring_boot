package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.SampleRepository;

//@EntityScan("com.example.demo.repository")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	   private final SampleRepository todoMapper;

	    public DemoApplication(SampleRepository todoMapper) {
	        this.todoMapper = todoMapper; // Mapperをインジェクションする
	    }
	    
}
