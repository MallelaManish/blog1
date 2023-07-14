package net.java.nlmp.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.java.nlmp.blog.exception.BlogAPIException;
import net.java.nlmp.blog.exception.ResourceNotFoundException;
import net.java.nlmp.blog.model.Comment;
import net.java.nlmp.blog.model.Post;
import net.java.nlmp.blog.payload.CommentDto;
import net.java.nlmp.blog.repository.CommentRespository;
import net.java.nlmp.blog.repository.PostRepository;
import net.java.nlmp.blog.service.CommentService;

@Service
public class CommentImpl implements CommentService {

	private CommentRespository commentRespository;
	private PostRepository postRepository;
	private ModelMapper mapper;

	public CommentImpl(CommentRespository commentRespository, PostRepository postRepository, ModelMapper mapper) {
		this.commentRespository = commentRespository;
		this.postRepository = postRepository;
		this.mapper = mapper;
	}

	@Override
	public CommentDto createComment(long postId, CommentDto commentDto) {
		// TODO Auto-generated method stub
		Comment comment = maptoModel(commentDto);
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Psot", "id", postId));

		//
		comment.setPost(post);

		//
		Comment newComment = commentRespository.save(comment);
		CommentDto newCommentDto = maptoDto(newComment);
		return newCommentDto;
	}

	@Override
	public List<CommentDto> getAllComments(long postId) {
		// TODO Auto-generated method stub
		List<Comment> comments = commentRespository.findByPostId(postId);
		List<CommentDto> commentDtos = comments.stream().map(comment -> maptoDto(comment)).collect(Collectors.toList());
		return commentDtos;
	}

	@Override
	public CommentDto getComment(long postId,long commentId) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(postId).orElseThrow(()
				->new ResourceNotFoundException("Psot", "id", postId));
		Comment comment = commentRespository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
		
		if(!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Comment does not belong to post");
		}
		
		return maptoDto(comment);
		
	}

	@Override
	public CommentDto updateComment(long postId, long commentId, CommentDto commentDto) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(postId).orElseThrow(()
				->new ResourceNotFoundException("Psot", "id", postId));
		Comment comment = commentRespository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
		if(!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Comment does not belong to post");
		}	
		
		Comment saveComment = maptoModel(commentDto);
		
		Comment newComment1 = commentRespository.save(saveComment);
		return maptoDto(newComment1);
	}
	
	private CommentDto maptoDto(Comment comment) {
		
		CommentDto commentDto = mapper.map(comment,CommentDto.class);
//		CommentDto commentDto = new CommentDto();
//		commentDto.setId(comment.getId());
//		commentDto.setName(comment.getName());
//		commentDto.setEmail(comment.getEmail());
//		commentDto.setComment(comment.getComment());
		return commentDto;
	}

	private Comment maptoModel(CommentDto commentDto) {
		
		Comment comment = mapper.map(commentDto, Comment.class);
//		Comment comment = new Comment();
//		comment.setId(commentDto.getId());
//		comment.setEmail(commentDto.getEmail());
//		comment.setName(commentDto.getName());
//		comment.setComment(commentDto.getComment());
		return comment;
	}

}
