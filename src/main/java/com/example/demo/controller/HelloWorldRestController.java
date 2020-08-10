package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class HelloWorldRestController {
	
	@GetMapping("hello")
	public String hello() {
		return "api ok !";
	}
}