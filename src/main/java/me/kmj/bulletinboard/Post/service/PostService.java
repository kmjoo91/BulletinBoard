package me.kmj.bulletinboard.Post.service;

import me.kmj.bulletinboard.Post.domain.Post;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;

public interface PostService {
	Long save(PostSaveRequest postSaveRequest);

	Post findById(long id);
}
