package me.kmj.bulletinboard.Post.service;

import me.kmj.bulletinboard.Post.domain.Post;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;
import me.kmj.bulletinboard.Post.dto.PostUpdateRequest;

public interface PostService {
	Long save(PostSaveRequest postSaveRequest);

	Post findById(long id);

	Long update(long id, PostUpdateRequest postUpdateRequest);
}
