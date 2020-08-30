package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleRedisCacheController {

	@Autowired
	CacheManager cm;

	@GetMapping("redisCache")
	public String redisCache() {

		Cache c1 = cm.getCache("cache1");
		c1.put("k1", 123456);
		c1.put("k2", 234567);

		Cache c2 = cm.getCache("cache2");
		c2.put("k1", 123456);
		c2.put("k2", 234567);

		return "redis cache test";
	}
}
