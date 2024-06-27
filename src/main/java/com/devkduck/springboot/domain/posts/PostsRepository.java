package com.devkduck.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    /*
    기본 CRUD가 생성됨 JpaRepository<Entity클래스, PK 타입>
     */
}
