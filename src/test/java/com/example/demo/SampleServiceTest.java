package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.Message;


//@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
class SampleServiceTest {

	// テスト対象、サービスクラス
	@Autowired
	private Message msg;
	
	private static final String errmsg="想定と異なる値です";

	@Test
	void サービスクラスのテスト１() {
		Assertions.assertEquals(msg.getMessage(true), "black", errmsg);
	}

}
