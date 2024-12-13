package com.dh.sportspot.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User{
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

    @Enumerated(EnumType.STRING)  // Enum 타입을 저장할 때는 @Enumerated 사용
    @Column(length = 20)
    private URoles uRoles;  // Enum 타입으로 설정

}
