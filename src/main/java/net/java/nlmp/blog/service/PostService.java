package net.java.nlmp.blog.service;

import java.util.List;

import net.java.nlmp.blog.payload.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto);
	
	List<PostDto> getPosts();
	
	PostDto getPostById(long id);

}
