package net.java.nlmp.blog.service;

import java.util.List;

import net.java.nlmp.blog.payload.PostDto;
import net.java.nlmp.blog.payload.PostResponse;

public interface PostService {
	
	PostDto createPost(PostDto postDto);
	
	List<PostDto> getPosts();
	
	PostResponse getPostsUsingPageination(int pageNo, int pageSize);
	
	PostResponse getPostsUsingPageination(int pageNo, int pageSize, String sortBy);
	
	PostDto getPostById(long id);

	PostResponse getPostsUsingPageination(int pageNo, int pageSize, String sortBy, String sortDir);

}
