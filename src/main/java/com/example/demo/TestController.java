package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //@ <-- Annotation
public class TestController {
	
	@Autowired // 급하냥과 와플곰이 협력하기 위해 마을 시스템에 와플곰을 불러달라 요청
	private PostService postService;
	
	@GetMapping("/test1") // 사용자 요청 처리
//	@ResponseBody
	public String hi() {
		return "test";
	}
	
	//board.html
	@GetMapping("/show")
	public String showPostForm() {
		// 급하냥이 데이터 찾기가 힘들어서 와플곰에게 요청(필요한 만큼의 데이터를 불러와줘)
		// -> Post 타입의 List posts라는 인스턴스를 선언
		// -> 내용은 postService라는 객체로부터 findAll 이라는 메서드 호출
		List<Post> posts = postService.findAll();
		return "board";
	}
	
	//create.html
	@GetMapping("/create")
	public String createPost() {
		return "create";
	}
	
}