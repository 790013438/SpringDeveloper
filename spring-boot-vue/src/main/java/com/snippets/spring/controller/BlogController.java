package com.snippets.spring.controller;

import com.snippets.spring.commons.dto.PostDTO;
import com.snippets.spring.commons.entity.PostEntity;
import com.snippets.spring.commons.service.PostService;
import com.snippets.spring.commons.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class BlogController {

    private final PostService postService;

    @Autowired
    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostVO> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/post")
    public ResponseEntity<?> publishPost(@Valid @RequestBody PostDTO postDTO) {
        if (!Objects.isNull(postService.insert(postDTO))) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
