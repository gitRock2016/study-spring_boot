package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.Message;


@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
class SampleTest {

	@Autowired
	private MockMvc mockMvc;

	@Value("${sample.key1}")
	private String appli_value1;

	@Autowired
	private Message msg;
	
//	@Test
	void fail() {
		Assertions.fail("必ず失敗するクラス");
	}

	@Test
	void フィールドの値を確認する() {
		Assertions.assertEquals("key1のValueで", appli_value1, "想定と異なる値です");
	}
	
	// Assertions.assertEquals( expected, actual);
	@Test
	void 基本テスト１() {
		Assertions.assertEquals("key1のValueです", appli_value1);
	}
	
	@Test
	void Service_isBalck() {
		Assertions.assertEquals(msg.getMessage(true), "black");
	}
	
	@Test
	void chaoエンドポイントがたたかれ200が返る() throws Exception {
		// andDo(print())でリクエスト・レスポンスを表示
		this.mockMvc.perform(get("/api/sample/chao")).andDo(print()).andExpect(status().isOk());

		System.out.print(appli_value1);

	}

}
