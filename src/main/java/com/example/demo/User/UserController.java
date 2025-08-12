package com.example.demo.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user") // 기본 주소 등록
public class UserController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserController(UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup") 
	// @RequestParam -> 폼으로부터 넘어온 데이터를 잡기 힘들때 이 어노테이션으로 연결 설정
	public String signup(@RequestParam(value="username") String username, 
						@RequestParam(value="password") String password) {
		SiteUser user = new SiteUser(username, passwordEncoder.encode(password), "USER");
		userRepository.save(user);
		return "redirect:/login";
	}
	

}