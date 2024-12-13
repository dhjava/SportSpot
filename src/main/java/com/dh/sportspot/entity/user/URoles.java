package com.dh.sportspot.entity.user;

import lombok.Getter;

@Getter
public enum URoles {
    ADMIN("관리자", 1),
    MANAGER("매니저", 2),
    MEMBER("일반 사용자", 3);

    private final String description;
    private final int priority;

    // 생성자
    URoles(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    // 권한 문자열 반환
    public String getAuthority() {
        return "ROLE_" + this.name();  // ROLE_ 접두어 추가
    }

    // 우선순위 비교 메서드
    public static int comparePriority(URoles role1, URoles role2) {
        return Integer.compare(role1.getPriority(), role2.getPriority());
    }
}
