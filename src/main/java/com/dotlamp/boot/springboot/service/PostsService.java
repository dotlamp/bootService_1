package com.dotlamp.boot.springboot.service;

import com.dotlamp.boot.springboot.domain.posts.Posts;
import com.dotlamp.boot.springboot.domain.posts.PostsRepository;
import com.dotlamp.boot.springboot.web.dto.PostsListResponseDto;
import com.dotlamp.boot.springboot.web.dto.PostsResponseDto;
import com.dotlamp.boot.springboot.web.dto.PostsSaveRequestDto;
import com.dotlamp.boot.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.IllegalChannelGroupException;
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
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당사용자는 없습니다 id = "+id));
     posts.update(requestDto.getTitle(), requestDto.getContent());
     return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts enity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당사용자는 없습니다 id = "+id));
        return new PostsResponseDto(enity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(posts -> new PostsListResponseDto(posts)).collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        postsRepository.delete(posts);
    }

}