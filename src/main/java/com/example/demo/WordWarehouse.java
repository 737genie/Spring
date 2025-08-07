package com.example.demo;

public class WordWarehouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스프링 용어 정리집
		
		// 1. ORM
		//  : Object Relational Mapping
		//  -> 프로그래밍 문법으로 DB를 다룰 수 있는 방법
		//  -> ORM을 이용하면 SQL을 직접 쓰지 않아도 DB를 활용하는 것이 가능(이론상)

		// 2. JPA
		//  : Java Persistence API
		//  -> JPA는 자바의 ORM 프레임워크
		//  -> JPA를 실제로 구현한 클래스 중 대표적인 것: 하이버네이트
		
		// 3. @Autowired : 해당 필드, 생성자 또는 메서드에 대해 스프링 컨테이너가
		//				   적절한 객체(Bean)를 찾아 자동으로 주입해주는 어노테이션
		
		// 4. JUnit :  테스트 코드를 작성하고, 실행할 때 사용하는 자바의 프레임워크
		// -> 스프링과는 별개의 프레임워크
		
		// Oracle, MySQL - DB management system (DB 관리 시스템)
		
		// -- Entity 용어집 --
		// 1. @Entity ; 스프링이 해당 클래스를 엔티티 객체로 인식하도록 하는 어노테이션
		// 2. @Id ; 기본키 설정
		//        ; 고유한 값인 컬럼(멤버 변수)을 설정해야해서 중복 없는 컬럼으로 설정
		// 3. @GeneratedValue ; 데이터 저장 시 해당 속성에 값을 지정하지 않아도 자동증가
		// 4. strategy = GenerationType.IDENTITY ; 고유한 번호 생성방법을 지정하는 부분
		//    			 				- IDENTITY ; db가 기본 키값을 자동 생성하도록 유도
		// 	  			 - GenerationType ; 전략 설정
		// 5. @Column ; 컬럼(멤버 변수)에 다양한 제약 조건 설정 가능
		//    -> 컬럼의 세부 설정 진행
		//	  --> length: 길이 설정
		//	  --> columnDefinition: 컬럼 데이터 유형, 성격 정의 
		// 	  	  -> TEXT: 문자(텍스트)들을 컬럼 데이터로 넣을 수 있음
		//         ex. @Column(columnDefinition: "TEXT")
		//	  --> name: DBMS 컬럼명(흔히 db에 써둔 컬럼명과 일치시킬 때 씀)
		//	  --> nullable: null 값 허용 여부
		//    --> unique
		//    --> precision: 전체 자릿수 설정
		//    --> scale: 소숫점 이하 자릿수
		//        ex. @Column(precision=10, scale=2)
		//        ex. decimal(10,2);
		
		
		// - Entity(테이블) 연관 관계 매핑 어노테이션 -
		// 1. @ManyToOne : 1:N
		// 2. @OneToMany : N:1
		// 3. @ManyToMany : N:M
		
		
		// 유효성 검사(validation check)
		// 1. @NotNull(message="메세지") : null 값 XX
		// 2. @NotBlank(message="메세지") : 공백 XX
		// 3. @Size(min=2, max=50, message="메세지") : 최소, 최대 크기 부여 가능
		// 4. @Email() : 이메일 형식 검증
		
		// 숫자 관련
		// 1. @Min(value=20)
		// 2. @Max
		// 3. @Pattern(정규 표현식을 활용하여 많은 조건을 지정할 수 있음
		
		// 날짜 관련
//	    @CreatedDate
//	    private LocalDateTime createdAt;
//	    // 토심이: "생성 시간은 제가 자동으로 기록해드릴게요!"
//	    
//	    @LastModifiedDate  
//	    private LocalDateTime updatedAt;
//	    // 토심이: "수정 시간도 실시간으로 업데이트해드려요!"
//	    
//	    @CreatedBy
//	    private String createdBy;
//	    // 토심이: "누가 만들었는지도 기록할 수 있어요!"
//	    
//	    @LastModifiedBy
//	    private String lastModifiedBy;
//	    // 토심이: "마지막 수정자도 추적 가능합니다!"
		
		
		
		
	}

}
