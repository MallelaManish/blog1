package net.java.nlmp.blog.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.java.nlmp.blog.exception.ResourceNotFoundException;
import net.java.nlmp.blog.model.Post;
import net.java.nlmp.blog.payload.PostDto;
import net.java.nlmp.blog.payload.PostResponse;
import net.java.nlmp.blog.repository.PostRepository;
import net.java.nlmp.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	private PostRepository postRepository;
	
	@Autowired // not need if there is only one dependecy
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public PostDto createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		//convert Dto to entit
		Post post = mapToModel(postDto);
		
		Post newPost = postRepository.save(post);
		
		PostDto postResponse = mapToDTO(newPost);
		
		
		return postResponse;
	}

	@Override
	public List<PostDto> getPosts() {
		// TODO Auto-generated method stub
	    List<Post> posts = postRepository.findAll();
	    return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
	    
	}
	
	private PostDto mapToDTO(Post post) {
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());
		return postDto;
	}
	
	private Post mapToModel(PostDto postDto) {
		Post post = new Post();
		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		return post;
	}

	@Override
	public PostDto getPostById(long id) {
		// TODO Auto-generated method stu
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post","id",id));
        PostDto postDto = mapToDTO(post);
		return postDto;
	}

	@Override
	public PostResponse getPostsUsingPageination(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		 Page<Post> post=postRepository.findAll(pageable);
		 List<Post> listOfPost = post.getContent();
		 List<PostDto> postDto = post.stream().map(posts -> mapToDTO(posts)).collect(Collectors.toList());
		 
		 PostResponse postResponse = new PostResponse();
		 postResponse.setContent(postDto);
		 postResponse.setPageNo(post.getNumber());
		 postResponse.setPageSize(post.getSize());
		 postResponse.setTotalElements(post.getTotalElements());
		 postResponse.setTotalPages(post.getTotalPages());
		 postResponse.setLast(post.isLast());
		 return postResponse;
	}
	
	

}
