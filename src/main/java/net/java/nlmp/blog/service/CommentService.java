package net.java.nlmp.blog.service;

import java.util.List;

import net.java.nlmp.blog.payload.CommentDto;

public interface CommentService {
	
	CommentDto createComment(long postId, CommentDto commentDto);
	
	List<CommentDto> getAllComments(long postId);
	
	CommentDto getComment(long postId,long commentId);
	
	CommentDto updateComment(long postId, long commentId, CommentDto commentDto);
	
	

}
