package me.kmj.bulletinboard.Post.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostUpdateRequest {
	private String title;
	private String content;
}
