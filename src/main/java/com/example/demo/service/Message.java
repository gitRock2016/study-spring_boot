package com.example.demo.service;

import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.web.bind.annotation.GetMapping;

public interface Message {
	String getMessage();
	String getMessage(boolean is);

	
}
