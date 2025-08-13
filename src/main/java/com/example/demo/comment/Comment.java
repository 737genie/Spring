package com.example.demo.comment;

import java.time.LocalDateTime;

import com.example.demo.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	@Id // 카피바라는 이 멤버변수를 통해서 각각의 데이터들을 구분할 것
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 위의 어노테이션은 카피바라가 일일이 번호 붙이기 귀찮아서 들어온 순서대로 1번부터 부여할 것임을 선언
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createAt;
	
	@ManyToOne // 여러개의 댓글이 하나의 게시글을 바라봄
	private Post post;
	
//	@ManyToOne
//	private SiteUser author;
}
