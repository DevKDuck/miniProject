package com.devkduck.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args){
        //내장 WAS 실행
        //언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있게 하기 위함
        SpringApplication.run(Application.class, args);
    }
}
