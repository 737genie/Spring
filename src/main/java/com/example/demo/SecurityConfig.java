package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// 시큐리티 설정 파일
@Configuration // 이 파일이 스프링의 환경 설정 파일임을 의미하는 어노테이션
@EnableWebSecurity // 모든 요청된 URL이 스프링 시큐리티의 제어를 받도록 만드는 어노테이션
public class SecurityConfig {
	// 어노테이션으로 시큐리티를 스프링에 등록
	// 시큐리티에는 SecurityFilterChain 클래스가 동작하면서
	// 모든 요청 URL에 이 클래스가 필터로 적용
	// 스프링 시큐리티는 더 세부적으로 분할, 자세히 설정할 수도 있음
	
	// http.authorizeHttpRequests() : http 요청에 대한 인증 및 권한 부여 규칙 설정 메서드
	// authorizeHttpRequests : 요청 권한을 설정하는 람다식 내부에서 요청매칭 조건과 권한 정의
	// requestMatchers(new AntPathRequestMatcher("/**")) : 모든 URL 패턴에 대해 매칭
	// AntPathRequestMatcher -> Ant 스타일의 경로 매칭 제공
	// -> /, /home, /api/** 이런 스타일의 경로 포함
	
	
	// 시큐리티는 기본적으로 웹 보안에 위배되는 공격의 방어가 기본
	// 예를 들어 CSRF는 웹 보안 공격 중 하나
	// 이걸 방지하기 위해 CSRF 토큰 세션을 통해 발행함
	
	//h2-console에 문제 발생하는 이유
	// h2-console은 db영역이기 때문에 스프링과는 상관이 없음 따라서 CSRF 토큰 발행할 수 없음
	// h2-console을 위해 csrf를 허용해 준다 쳐도 화면 자체를 볼 수 없는 증상 발생
	//  - X-Frame-Options: 클릭재킹 공격을 막기 위해 사용
	
	
	@Bean
	   SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		      http
		      .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
		            .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		      .csrf((csrf) -> csrf
		      .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
	          .headers((headers) -> headers
	                  .addHeaderWriter(new XFrameOptionsHeaderWriter(
	                      XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
	            .formLogin((formLogin) -> formLogin
	                    .loginPage("/user/login") // 로그인 페이지의 URL
	                    .defaultSuccessUrl("/show")) // 로그인 성공 시 이동할 기본 URL
	                .logout((logout) -> logout
	                    .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) // 로그아웃 URL
	                    .logoutSuccessUrl("/show") // 로그아웃 성공 시 이동할 URL
	                    .invalidateHttpSession(true)); // 세션 무효화
		      return http.build();
		   }
	
	// db 비밀번호 암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	
}
