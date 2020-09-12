package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix="sample-test")
public class SampleProperty {
	private String message;
	private String language;
	private String java;
	private String version;
	private String enabled;
}
