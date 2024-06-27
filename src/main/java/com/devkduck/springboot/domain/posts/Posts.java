package com.devkduck.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity// 테이블과 링크될 클래스
public class Posts {

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙 GenerationType.IDENTITY - auto increment
    private Long id;

    // varchar(255) 기본
    @Column(length = 500, nullable = false)
    private String title;

    // 타입을 Text로 변경하고 싶을 경우
    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    @Builder // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
