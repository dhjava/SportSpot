package com.dh.sportspot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/user/**").not().authenticated()
                        // 추후 관리자 페이지 생성 시 괄호 안 "/admin/**" 추가
                        .requestMatchers("/notice/write", "/notice/modify").hasAnyRole("admin", "manager")
                        .requestMatchers("/mypage/**", "/write", "/modify").authenticated()
                        .anyRequest().permitAll())
                
                .formLogin(form -> form
                        .loginPage("/user/login")  // 로그인 페이지 URL
                        .defaultSuccessUrl("/", true)  // 로그인 성공 후 기본 URL
                        .permitAll()  // 로그인 페이지는 누구나 접근 가능
                        .successHandler((request, response, authentication) -> {
                            // 로그인 후 원래 요청한 URL로 리다이렉트
                            String referer = request.getHeader("Referer");
                            if (referer != null) {
                                response.sendRedirect(referer);
                            } else {
                                response.sendRedirect("/");
                            }
                        })
                        .failureHandler((request, response, exception) -> {
                            // 로그인 실패 후 리다이렉트
                            request.getSession().setAttribute("loginError", "올바른 ID와 비밀번호를 입력해주십시오.");
                            response.sendRedirect("/user/login?error=true");  // 로그인 실패 후 리다이렉트
                        })
                )
                .logout(logout -> logout
                        .permitAll()  // 로그아웃 페이지는 누구나 접근 가능
                        .logoutSuccessHandler((request, response, authentication) -> {
                            // 로그아웃 후 원래 URL로 리다이렉트
                            String referer = request.getHeader("Referer");
                            if (referer != null) {
                                response.sendRedirect(referer);
                            } else {
                                response.sendRedirect("/login?logout");
                            }
                        })
                );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}