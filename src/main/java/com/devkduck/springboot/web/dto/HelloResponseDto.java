package com.devkduck.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get 메서드 생성
@RequiredArgsConstructor //final 필드가 포함된 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
