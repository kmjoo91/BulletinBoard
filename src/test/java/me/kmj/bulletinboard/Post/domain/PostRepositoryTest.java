package me.kmj.bulletinboard.Post.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {
	@Autowired
	PostRepository postRepository;

	@AfterEach
	void tearDown() {
		postRepository.deleteAll();
	}

	@DisplayName("저장된 게시글 불러오기")
	@Test
	void load_post() {
		//given
		Post post = Post.builder()
				.title("테스트게시글")
				.content("테스트본문")
				.author("작성자")
				.build();

		postRepository.save(post);

		//when
		List<Post> postList = postRepository.findAll();

		//then
		Post actual = postList.get(0);
		assertThat(actual.getTitle()).isEqualTo(post.getTitle());
		assertThat(actual.getContent()).isEqualTo(post.getContent());
		assertThat(actual.getAuthor()).isEqualTo(post.getAuthor());
	}
}