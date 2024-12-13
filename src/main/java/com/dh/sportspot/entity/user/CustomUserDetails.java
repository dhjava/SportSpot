package com.dh.sportspot.entity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(user.getURoles())  // 단일 역할을 List로 감싸기
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))  // 권한 생성
                .collect(Collectors.toList());
    }


    // Spring Security 관련 코드
    @Override
    public String getPassword() {
        return user.getUPw();
    }

    @Override
    public String getUsername() {
        return user.getUId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부 반환 (true: 만료되지 않음)
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠금 여부 반환 (true: 잠금되지 않음)
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 패스워드 만료 여부 반환 (true: 만료되지 않음)
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성화 여부 반환 (true: 활성화)
    }
}
