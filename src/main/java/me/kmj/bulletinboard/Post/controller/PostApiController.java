package me.kmj.bulletinboard.Post.controller;

import lombok.AllArgsConstructor;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;
import me.kmj.bulletinboard.Post.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PostApiController {
	private final PostService postService;

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostSaveRequest postSaveRequest) {
		return postService.save(postSaveRequest);
	}
}
