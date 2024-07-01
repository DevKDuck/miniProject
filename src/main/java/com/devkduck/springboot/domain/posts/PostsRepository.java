package com.devkduck.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    /*
    기본 CRUD가 생성됨 JpaRepository<Entity클래스, PK 타입>
     */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    /*
    조회용 프레임워크 querydsl을 많이 사용함
     */
}
