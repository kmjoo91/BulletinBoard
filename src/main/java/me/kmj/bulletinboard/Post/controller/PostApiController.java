package me.kmj.bulletinboard.Post.controller;

import lombok.AllArgsConstructor;
import me.kmj.bulletinboard.Post.dto.PostResponse;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;
import me.kmj.bulletinboard.Post.dto.PostUpdateRequest;
import me.kmj.bulletinboard.Post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostApiController {
	private final PostService postService;

	@GetMapping("/{id}")
	public PostResponse findById(@PathVariable @Min(1) long id) {
		return new PostResponse(postService.findById(id));
	}

	@PostMapping
	public Long save(@RequestBody PostSaveRequest postSaveRequest) {
		return postService.save(postSaveRequest);
	}

	@PutMapping("/{id}")
	public Long update(@PathVariable @Min(1) long id, @RequestBody PostUpdateRequest postUpdateRequest) {
		return postService.update(id, postUpdateRequest);
	}
}
