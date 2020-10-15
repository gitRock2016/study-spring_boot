package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImple implements Message{

	@Override
	public String getMessage() {
		return "hello";
	}

	@Override
	public String getMessage(boolean is) {
		if(is) return "black";
		return "white";
	}

}
