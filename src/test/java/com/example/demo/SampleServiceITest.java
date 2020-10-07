package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.Message;

//@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
class SampleServiceITest {

	// テスト対象、サービスクラス
	@Autowired
	private Message msg;

	private static final String errmsg = "想定と異なる値です";

	@Test
	void サービスクラスのテスト１() {
		assertEquals("black", msg.getMessage(true), errmsg);
	}

}
