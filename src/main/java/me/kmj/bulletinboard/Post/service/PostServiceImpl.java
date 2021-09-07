package me.kmj.bulletinboard.Post.service;

import lombok.AllArgsConstructor;
import me.kmj.bulletinboard.Post.domain.Post;
import me.kmj.bulletinboard.Post.domain.PostRepository;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;
import me.kmj.bulletinboard.Post.dto.PostUpdateRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
		return postRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id));
	}

	@Transactional
	@Override
	public Long update(long id, PostUpdateRequest postUpdateRequest) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id));

		post.update(postUpdateRequest.getTitle(), postUpdateRequest.getContent());

		return post.getId();
	}
}
