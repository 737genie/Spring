package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.comment.Comment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// Post라고 하는 객체의 데이터 설계도(Entity)
// 카피바라는 이 설계도(상자)를 보고 데이터 창고에 저장할 영역(테이블)을 만들어줌
// Entity 어노테이션은 종속된 클래스가 JPA에 의해 관리되는 정보임을 나타냄
@Entity
public class Post {
	
	@Id // 카피바라는 이 멤버변수를 통해서 각각의 데이터들을 구분할 것
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 위의 어노테이션은 카피바라가 일일이 번호 붙이기 귀찮아서 들어온 순서대로 1번부터 부여할 것임을 선언
	private Long id;
	@Column(length=200)
	private String title;
	@Column()
	private String content;
	private LocalDateTime createAt;
	
	// JPA가 적용되면 기본 생성자를 요구하기 때문에 써야함.
	public Post() {}
	
	public Post(String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.createAt = LocalDateTime.now();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}
	
	public void update(String title2, String content2) {
		this.title = title2;
		this.content = content2;
		this.createAt = LocalDateTime.now();
	}
	
	// 하나의 게시글은 여러 개의 댓글을 가질 수 있다
	// mappedBy - Comment 엔티티의 post 필드에 의해 관계가 관리됨을 명시
	// CascadeType.REMOVE : 이 게시글이 삭제되면 관련된 모든 댓글도 삭제됨
	@OneToMany(mappedBy="post", cascade = CascadeType.REMOVE)
	private List<Comment> commentList;
	
}
