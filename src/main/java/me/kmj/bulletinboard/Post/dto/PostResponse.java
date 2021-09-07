package me.kmj.bulletinboard.Post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kmj.bulletinboard.Post.domain.Post;

@Getter
@NoArgsConstructor
public class PostResponse {
	private long id;
	private String title;
	private String content;
	private String author;

	public PostResponse(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.author = post.getAuthor();
	}
}
