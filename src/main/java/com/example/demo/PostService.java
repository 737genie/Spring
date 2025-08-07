package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	// 와플곰이 자신의 업무에 필요한
	// 데이터 저장을 위해 카피바라에게 전달하는 과정
	
	private final PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository=postRepository;
	}
	
	// 와플곰이 해야할 일
	// 데이터 관련 일이 필요함.
	// -> << CRUD 관리 >> Create, Read, Update, Delete
	
	// 게시글 저장 로직
	public Long save(PostCreateDto dto) {
		// 사실 저장할 때 리턴타입 없어도 저장 가능
		// 지금의 경우는 > 리턴값을 통해서 데이터 저장 후의 로직을 처리하기 위함임
		return postRepository.save(dto.toEntity()).getId();
	}
	
	public List<Post> findAll() {
//		System.out.println("급하냥이 와플곰에게 데이터를 조회해달라고 요청."); // 현업에서는 금지 (정보 유출 가능성)
		
		return postRepository.findAll();
	}
	
	public void detail(Long id) {
		Optional<Post> o1 = this.postRepository.findById(id);
	}
}
