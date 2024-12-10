package com.dh.sportspot.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {
    //field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uNo", unique = true, nullable = false)
    private Long uNo;

    @Column(length = 20, unique = true, nullable = false)
    private String uId;

    @Column(length = 60, nullable = false) // 암호화된 비밀번호 길이에 맞게 수정
    private String uPw;

    @Column(length = 20, nullable = false)
    private String uNickName;

    @Column(length = 40, unique = true, nullable = false)
    private String uMail;

    @Column(length = 11)
    private String uPhone;

    @Column(length = 20)
    private String uRegionA;

    @Column(length = 20)
    private String uRegionB;

    // 권한을 저장하기 위한 필드 (콤마로 구분된 한 글자 권한 값)
    @Column(length = 20, nullable = false)
    private String roles; // 예: "admin, member, manager, banned"

    // UserDetails 메서드 구현
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // roles 필드를 ','로 분리하여 GrantedAuthority 객체 리스트로 변환
        return List.of(roles.split(",")).stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // "ROLE_" 접두어를 붙여 권한을 생성
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return uPw;
    }

    @Override
    public String getUsername() {
        return uId;
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
