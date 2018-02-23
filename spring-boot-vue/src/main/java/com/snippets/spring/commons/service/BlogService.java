package com.snippets.spring.commons.service;

import com.snippets.spring.commons.dto.PostDTO;
import com.snippets.spring.commons.entity.PostEntity;
import com.snippets.spring.commons.vo.PostVO;

import java.util.List;

public interface BlogService {

    List<PostVO> getAllPosts();

    PostEntity insert(PostDTO post);
}
