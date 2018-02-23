package com.snippets.spring.commons.service;

import com.snippets.spring.commons.dto.PostDTO;
import com.snippets.spring.commons.entity.PostEntity;
import com.snippets.spring.commons.util.ValidateUtils;
import com.snippets.spring.commons.vo.PostVO;
import com.snippets.spring.repository.PostRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements BlogService {

    private final PostRepository postRepository;
    private final Mapper mapper;

    @Autowired
    public PostService(PostRepository postRepository, Mapper mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    public List<PostVO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(
                        e -> mapper.map(e, PostVO.class)
                )
                .collect(Collectors.toList());
    }

    public PostEntity insert(PostDTO postDTO) {
        ValidateUtils.validateNotNull(postDTO, "post不存在");
        PostEntity postEntity = mapper.map(postDTO, PostEntity.class);
        return postRepository.save(postEntity);
    }
}
