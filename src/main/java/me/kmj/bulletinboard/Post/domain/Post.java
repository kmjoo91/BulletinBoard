package me.kmj.bulletinboard.Post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(length = 20)
	private String author;

	@Builder
	public Post(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
