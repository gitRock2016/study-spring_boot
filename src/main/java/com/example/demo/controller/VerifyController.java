package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.SampleProperty;
import com.example.demo.form.ChaoForm;
import com.example.demo.repository.SampleRepository;
import com.example.demo.repository.entity.Todo;


@Controller
@RequestMapping("test")
public class VerifyController {

	@Value("${sampleTest.message}")
	private String s_message;
	
	@Autowired
	SampleProperty sp;
	@Autowired
	SampleRepository repo;
	
	/**
	 * JUNITテスト用
	 * @return
	 */
	@GetMapping("chao")
	public String chao(Model model) {
		
		model.addAttribute("message", s_message);
		ChaoForm chf = new ChaoForm();
		chf.setLanguage(sp.getLanguage());
		chf.setVersion(sp.getVersion());
		model.addAttribute("languageInfo", chf);
		
		Optional<Todo> todo = repo.findById(2);
		Todo t = todo.get();
		model.addAttribute("todoId", t.getTodoId());
		model.addAttribute("todoTitle", t.getTodoTitle());
		
		
		return "sample/chao";
	}
}