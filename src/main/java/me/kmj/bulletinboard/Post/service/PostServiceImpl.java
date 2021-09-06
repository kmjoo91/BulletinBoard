package me.kmj.bulletinboard.Post.service;

import lombok.AllArgsConstructor;
import me.kmj.bulletinboard.Post.domain.PostRepository;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
	private final PostRepository postRepository;

	@Override
	public Long save(PostSaveRequest postSaveRequest) {
		return postRepository.save(postSaveRequest.toPost()).getId();
	}
}
