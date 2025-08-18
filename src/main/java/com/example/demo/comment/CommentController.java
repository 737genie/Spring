package com.example.demo.comment;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Post;
import com.example.demo.PostService;
import com.example.demo.User.SiteUser;
import com.example.demo.User.UserRepository;

@RequestMapping("/comment") // 기본 주소 할당
@Controller // 컨트롤러 파일 만들면 처음에 해야하는 것
public class CommentController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@Autowired
	private CommentRepository commentRepository;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}")
	public String createComment(Model model, 
			@RequestParam(value="content") String content,
			@PathVariable("id") Long id,
			Principal principal) {
		Post post = this.postService.detail(id); // 특정 게시글 업데이트
		SiteUser author = this.userRepository.findByUsername(principal.getName()) // principal - 현재 인증된 사용자의 정보를 나타내는 객체(username을 들고 옴)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
		this.commentServiceImpl.create(post, content, author);
		return String.format("redirect:/show/%s", id);
	}
	
   @GetMapping("/modify/{id}")
   public String modifyComment(
		   Model model,
		   @PathVariable("id") Long id) {
	   Optional<Comment> o1 = this.commentRepository.findById(id);
	   Comment p = o1.get();
	   model.addAttribute("comment", p);
      return "comment_form";
   }
}
