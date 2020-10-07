package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	
	@Test
	void chaoエンドポイントへGETリクエストをして200が返却される() throws Exception {
		// andDo(print())でリクエスト・レスポンスを表示
		this.mockMvc.perform(get("/test/chao"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	void コントローラクラスのフィールドの値を確認する１() throws Exception {
		this.mockMvc.perform(get("/test/chao"))
		.andDo(print())
		.andExpect(model().attribute("message", "こんにちわ"));
	}
	
	/**
	 * HasPropertyWithValue.hasProperty」を利用する
	 * ※HasProperty」のほうではない
	 * ※メソッド名を記載してもstatic importの候補がでず、クラスファイルを調査して探すことになった→なぜでない？
	 * 
	 * @throws Exception
	 */
	@Test
	void コントローラクラスのフィールドの値を確認する2() throws Exception {
		this.mockMvc.perform(get("/test/chao"))
			// HTMLが返却されコンソール表示が煩雑になるので、コメントアウト
			// .andDo(print())
			.andExpect(model().attribute("languageInfo", hasProperty("language", is("java"))))
			// 複数のフィールドの値を検証する場合はの書き方が不明、とりあえずつなげたら書けるようだけど、冗長になる
			.andExpect(model().attribute("languageInfo", hasProperty("version", is("1.8"))));
	}
}