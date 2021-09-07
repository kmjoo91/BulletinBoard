package me.kmj.bulletinboard.Post.controller;

import me.kmj.bulletinboard.Post.domain.Post;
import me.kmj.bulletinboard.Post.domain.PostRepository;
import me.kmj.bulletinboard.Post.dto.PostResponse;
import me.kmj.bulletinboard.Post.dto.PostSaveRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostApiControllerTest {
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private PostRepository postRepository;
	
	@LocalServerPort
	private int port;

	@AfterEach
	void tearDown() {
		postRepository.deleteAll();
	}

	@DisplayName("포스트 저장")
	@Test
	public void save_post() {
		//given
		PostSaveRequest postSaveRequest = PostSaveRequest.builder()
				.title("게시글제목")
				.content("게시글내용")
				.author("작성자")
				.build();
		postRepository.save(postSaveRequest.toPost());

		String url = "http://localhost:" + port + "/api/v1/posts";

		//when
		ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, postSaveRequest, Long.class);

		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0);

		Post post = postRepository.findAll().get(0);
		assertThat(post.getId()).isGreaterThan(0);
		assertThat(post.getTitle()).isEqualTo(postSaveRequest.getTitle());
		assertThat(post.getContent()).isEqualTo(postSaveRequest.getContent());
		assertThat(post.getAuthor()).isEqualTo(postSaveRequest.getAuthor());
	}

	@DisplayName("포스트 가져오기")
	@Test
	public void findById_post() {
		//given
		PostSaveRequest postSaveRequest = PostSaveRequest.builder()
				.title("게시글제목")
				.content("게시글내용")
				.author("작성자")
				.build();
		long id = postRepository.save(postSaveRequest.toPost()).getId();

		String url = "http://localhost:" + port + "/api/v1/posts/" + id;

		//when
		ResponseEntity<PostResponse> responseEntity = testRestTemplate.getForEntity(url, PostResponse.class);

		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

		PostResponse postResponse = responseEntity.getBody();
		assertThat(postResponse.getId()).isGreaterThan(0);
		assertThat(postResponse.getTitle()).isEqualTo(postSaveRequest.getTitle());
		assertThat(postResponse.getContent()).isEqualTo(postSaveRequest.getContent());
		assertThat(postResponse.getAuthor()).isEqualTo(postSaveRequest.getAuthor());
	}

	@DisplayName("포스트 가져오기")
	@Test
	public void findById_InvalidId_post() {
		//given
		long id = 0;

		String url = "http://localhost:" + port + "/api/v1/posts/" + id;

		//when
		ResponseEntity<PostResponse> responseEntity = testRestTemplate.getForEntity(url, PostResponse.class);

		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}