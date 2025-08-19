package com.example.demo.comment;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

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
	@Autowired
	private CommentService commentService;
	
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
	
	@PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String modifyComment(
		   Model model,
		   @PathVariable("id") Long id,
		   Principal principal) { // principal 현재 접속한 유저의 정보를 알 수 있는 파라미터
		
	   Comment cmt = this.commentService.getComment(id);
	   if(!cmt.getAuthor().getUsername().equals(principal.getName())) { //댓글 쓴 사람 == 접속한 사용자 같은지 확인하는 작업
		   throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
	   }
	   model.addAttribute("comment", cmt);
      return "comment_form";
   }
	
	@PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String commentModify(
		   @PathVariable("id") Long id,
		   @RequestParam(value="content") String content,
		   Principal principal
		   ) {
		Comment cmt = this.commentService.getComment(id);
		   if(!cmt.getAuthor().getUsername().equals(principal.getName())) { //댓글 쓴 사람 == 접속한 사용자 같은지 확인하는 작업
			   throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
		   }
		this.commentService.modify(cmt, content);
		return String.format("redirect:/show/%s", cmt.getPost().getId());
    }
	
	@PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String deleteComment(
		   @PathVariable("id") Long id,
		   Principal principal) { // principal 현재 접속한 유저의 정보를 알 수 있는 파라미터
		
	   Comment cmt = this.commentService.getComment(id);
	   if(!cmt.getAuthor().getUsername().equals(principal.getName())) { //댓글 쓴 사람 == 접속한 사용자 같은지 확인하는 작업
		   throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
	   }
	   
	   this.commentService.delete(cmt);
	   return String.format("redirect:/show/%s", cmt.getPost().getId());
   }

	
	
}
