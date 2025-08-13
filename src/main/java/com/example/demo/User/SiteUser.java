package com.example.demo.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SiteUser {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String role;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}
	 
	//* 
	// jpa는 모든 엔티티 클래스에 기본 생성자를 요구함
	// 이유 - 리플렉션을 통한 객체 생성 구조이기 때문, db와 맞추는 과정에서 생성자가 꼭 필요함(매핑)
	// *리플렉션(api) - 실행중인 프로그램 구조 분석, 수정할 수 있는 기능을 제공하는 도구
	public SiteUser() {
		
	}

	public SiteUser(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
	
	
	
}