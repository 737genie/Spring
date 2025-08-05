package com.example.demo;

public class PostCreateDto {

	// Post Entity에는 4개의 멤버변수가 있음
	// 그 중 필요한 2개(사용자가 직접 입력)
	// 방문객이 급하냥에게 데이터를 보낼 때
	// 여기에 담아서 보내면 내용물이 섞이거나 분실될 위험이 없음
	
	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// Dto 자체는 Post(엔티티)와는 다른 클래스
	// 상속 관계로 두면 중복된 멤버변수들이 존재해서 굳이 상속으로 두지 않음
	public Post toEntity() {
		return new Post(title, content);
	}
	
}
