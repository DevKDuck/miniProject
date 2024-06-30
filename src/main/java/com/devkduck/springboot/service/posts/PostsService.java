package com.devkduck.springboot.service.posts;

//import com.devkduck.springboot.domain.posts.Posts;
import com.devkduck.springboot.domain.posts.PostsRepository;
//import com.devkduck.springboot.web.dto.PostsResponseDto;
import com.devkduck.springboot.web.dto.PostsSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

//    @Transactional
//    public Long update(Long id, PostsUpdateRequestDto requestDto) {
//        Posts posts = postsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다 id = " + id));
//
//        posts.update(requestDto.getTitle().requestDto.getContent());
//        return id;
//    }
//
//    public PostsResponseDto findById(Long id){
//        Posts entity = postsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
//        return new PostsResponseDto(entity);
//    }
}
