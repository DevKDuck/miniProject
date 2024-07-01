package com.devkduck.springboot.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //BaseTimeEntity 상속시 필드들을 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    //모든 Entity의 상위 클래스가 되어 Entityemfdml createdDate,modifiedDate 자동 관리

    @CreatedDate //Entity 생성되어 저장될때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
