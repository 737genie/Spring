package com.example.demo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {
	
	@Autowired
	private PostRepository postRepository; 
	@Test
	void contextLoads() {
//		
//		// Post 클래스를 기반으로 객체를 만들고 활용
//		Post p1 = new Post();
//		p1.setContent("내용");
//		p1.setTitle("제목");
//		p1.setCreateAt(LocalDateTime.now());
//		this.postRepository.save(p1);
		
//		Optional<Post> o1 = this.postRepository.findById(1L);
//		
//		Post p = o1.get();
//		System.out.println(p.getTitle());
//		System.out.println(p.getContent());
		
	}
	// RUN AS 	> JUnit 으로 구동 (서버는 꺼져있는 채로)
}
