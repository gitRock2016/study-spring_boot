package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import lombok.Data;

@Configuration
@PropertySource("classpath:/test-prop1.properties")
@Data
public class MessageConfigProperty {
	
	@Autowired
	private Environment env;

	// messageに限定しているようだが、Environmentを介するので色々取れる
	public String get(String key) {
		return env.getProperty(key);
	}

	
}
