package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ManagementConfigProperty;
import com.example.demo.config.MessageConfigProperty;

@RestController
@RequestMapping("/api/sample")
public class HelloWorldRestController {
	
	@Value("${sample.key1}")
	private String appli_value1;
	@Value("${test-prop.key1}")
	private String testProp_value1;
	@Autowired
	ManagementConfigProperty mgtConfProp;
	@Autowired
	MessageConfigProperty msgConfProp;
	
	@GetMapping("hello")
	public String hello() {
		
		System.out.println("◆@Value");
		System.out.println("application.properteisより:" + appli_value1);
		System.out.println("独自propetiesより:" + testProp_value1);
		System.out.println("");

		System.out.println("◆@ConfigurationProperties");
		System.out.println("DB:" + mgtConfProp.getDb());
		System.out.println("Table:" + mgtConfProp.getTable());
		System.out.println("ID:" + mgtConfProp.getAdmin().getId());
		System.out.println("user:" + mgtConfProp.getAdmin().getUser());
		System.out.println("");

		System.out.println("◆Environment");
		System.out.println("独自propetiesより:"+msgConfProp.get("settings.message.err-001"));
		System.out.println("");
		
		return "Hello World!";
	}
}