package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class PostService {
	// 와플곰은 급하냥이 처리해달라는 것만 처리해주면 됨
	// -> 컨트롤러에서 서비스단으로 데이터 조회, 수정, 삭제 등을 요청
	// 	  요청 사항만 수행하면 됨
	// ! 다만 데이터 가공, 검사 등은 여기서 수행
	// -> 가공, 검사가 끝나면 와플곰은 
	//    카피바라에게 데이터 창고의 내용을 요청, 
	//    혹은 데이터 창고에 내용들을 저장시킬 수 있음
	// -> 카피바라는 본인만의 특별한 아이템(JPA)을 사용하여 데이터 관리
	
	
	public void findAll() {
		System.out.println("급하냥이 와플곰에게 데이터를 조회해달라고 요청."); // 현업에서는 금지 (정보 유출 가능성)
		System.out.println("와플곰은 (카피바라에게 급하냥이 요청한 데이터가 있는지) 확인하는 작업 진행 - 미구현");
		
	}
	
}
