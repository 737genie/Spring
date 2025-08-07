package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String showPostForm(Model model) {
		// 급하냥이 데이터 찾기가 힘들어서 와플곰에게 요청(필요한 만큼의 데이터를 불러와줘)
		// -> Post 타입의 List posts라는 인스턴스를 선언
		// -> 내용은 postService라는 객체로부터 findAll 이라는 메서드 호출
		List<Post> posts = postService.findAll();
		// 리턴 타입이 맞아야 오류가 안남 > PostService 확인할 것
		
		model.addAttribute("posts", posts); // 모델을 통해 ui로 데이터를 넘김
//      model.addAttribute(ui에서 사용할 객체명, 넘길 인스턴스);
		return "board";
	}
	
	//create.html
	// 게시글 작성페이지로 이동하기 위한 메서드
	@GetMapping("/create") // getmapping 페이지 접근 및 조회
	public String createPost() {
		return "create";
	}
	
	// 실질적인 저장을 위한 메서드
	@PostMapping("/create") // postmapping 데이터 저장, 수정, 삭제
	public String createPost(PostCreateDto dto) {
		postService.save(dto);
		return "redirect:/show";
	}
	
	@GetMapping(value = "/show/{id}")
	public String showDetail(Model model, @PathVariable("id") Long id) { 
		// PathVariable 어노테이션이 있어야 템플릿에서 보낸 값을 받아올 수 있음
		
		// 와플곰(서비스단)에 요청
		postService.detail(id);
		model.addAttribute("post", result);
		return "detail";
	}
}