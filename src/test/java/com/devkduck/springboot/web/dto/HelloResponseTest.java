package com.devkduck.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseTest {
    @Test
    public void lombok_test(){
        String name = "test";
        int amount = 1000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
