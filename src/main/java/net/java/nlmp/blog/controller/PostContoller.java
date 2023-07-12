package net.java.nlmp.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.java.nlmp.blog.payload.PostDto;
import net.java.nlmp.blog.payload.PostResponse;
import net.java.nlmp.blog.service.PostService;
import net.java.nlmp.blog.service.impl.PostServiceImpl;

@RestController
@RequestMapping("/api/posts")
public class PostContoller {

	private PostService postImpl;

	@Autowired
	public PostContoller(PostService postImpl) {
		// TODO Auto-generated constructor stub
		this.postImpl = postImpl;
	}

	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
		return new ResponseEntity<>(postImpl.createPost(postDto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPosts() {
		return new ResponseEntity<List<PostDto>>(postImpl.getPosts(), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
		return new ResponseEntity<PostDto>(postImpl.getPostById(id), HttpStatus.ACCEPTED);

	}
	
	@PostMapping("/get-posts")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public ResponseEntity<PostResponse> getAllPostsByPages(@RequestParam(value = "pageNo",defaultValue = "0" , required = false)
	int pageNo,@RequestParam(value = "pageSize",defaultValue = "10", required = false) int pageSize ) {
		System.out.println(pageNo);
		System.out.println(pageSize);
		return new ResponseEntity<PostResponse>(postImpl.getPostsUsingPageination(pageNo, pageSize), HttpStatus.ACCEPTED);
	}
	

}
