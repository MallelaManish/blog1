package net.java.nlmp.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.nlmp.blog.payload.CommentDto;
import net.java.nlmp.blog.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long id,
			@RequestBody CommentDto commentDto) {
		return new ResponseEntity<CommentDto>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
	}

	@GetMapping("/post/{postId}/comments")
	public ResponseEntity<List<CommentDto>> getComments(@PathVariable("postId") long postId) {
		return new ResponseEntity<List<CommentDto>>(commentService.getAllComments(postId), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{postId}/{commentId}/comment")
	public ResponseEntity<CommentDto> getComment(@PathVariable("postId") long postId,
			@PathVariable("commentId") long commentId) {
		return new ResponseEntity<CommentDto>(commentService.getComment(postId, commentId), HttpStatus.OK);
	}

	@PutMapping("/{postId}/comment/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable("postId") long postId,
			@PathVariable("commentId") long id, @RequestBody CommentDto commentDto) {
		return new ResponseEntity<CommentDto>(commentService.updateComment(postId, id, commentDto), HttpStatus.OK);
	}

}
