package com.devkduck.springboot.service.posts;

import com.devkduck.springboot.domain.posts.Posts;
import com.devkduck.springboot.domain.posts.PostsRepository;
import com.devkduck.springboot.web.dto.PostsListResponseDto;
import com.devkduck.springboot.web.dto.PostsResponseDto;
import com.devkduck.springboot.web.dto.PostsSaveRequestDto;
import com.devkduck.springboot.web.dto.PostsUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found User id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }


    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found User id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not found User id=" + id));
        postsRepository.delete(posts);
    }
}
