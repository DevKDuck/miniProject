package com.devkduck.springboot.config.auth.dto;

import com.devkduck.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private Long id;
    private String name;
    private String email;

    public SessionUser(User user) {
        if (user != null) {
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
        } else {
            // 적절한 예외 처리 또는 기본값 설정
            this.id = null;
            this.name = null;
            this.email = null;
        }
    }
}
