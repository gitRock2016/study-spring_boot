package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "account.management")
@Data
public class ManagementConfigProperty {
	private String db;
	private String table;
	private Admin admin = new Admin();

	@Data
	public class Admin {
		private String user;
		private String id;
	}

}
