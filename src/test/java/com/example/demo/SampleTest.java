package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
class SampleTest {
	
	// テスト対象
	// 設定値を直接取得する
	@Value("${sampleTest.message}")
	private String s_message;

	private static final String errmsg = "想定と異なる値です";

	@Test
	void テストクラスのフィールドの値を確認する() {
		Assertions.assertEquals("こんにちわ", s_message, errmsg);
	}

}
