package me.kmj.bulletinboard.Post.service;

import lombok.AllArgsConstructor;
import me.kmj.bulletinboard.Post.domain.Post;
import me.kmj.bulletinboard.Post.domain.PostRepository;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
	public static final int MINIMUM_ID = 1;
	private final PostRepository postRepository;

	@Override
	public Long save(PostSaveRequest postSaveRequest) {
		return postRepository.save(postSaveRequest.toPost()).getId();
	}

	@Override
	public Post findById(long id) {
		return postRepository.findById(id).orElse(null);
	}
}
