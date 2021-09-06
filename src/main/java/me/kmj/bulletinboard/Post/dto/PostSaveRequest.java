package me.kmj.bulletinboard.Post.dto;

import lombok.Builder;
import lombok.Getter;
import me.kmj.bulletinboard.Post.domain.Post;

@Builder
@Getter
public class PostSaveRequest {
	private String title;
	private String content;
	private String author;

	public Post toPost() {
		return Post.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
