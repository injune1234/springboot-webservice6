package com.jvision.admin201618049.service;

import com.jvision.admin201618049.domain.posts.Posts;
import com.jvision.admin201618049.domain.posts.PostsRepository;
import com.jvision.admin201618049.web.dto.PostsListResponseDto;
import com.jvision.admin201618049.web.dto.PostsResponseDto;
import com.jvision.admin201618049.web.dto.PostsSaveRequestDto;
import com.jvision.admin201618049.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="));
        posts.update(requestDto.getTitle(), requestDto.getName(), requestDto.getTel(), requestDto.getAddress(), requestDto.getIntro());
        return id;
    }

    @Transactional
    public void delete(Long id)
    {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

    @Transactional
    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }


    @Transactional
    public List<PostsListResponseDto> findAllDesc()
    {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
