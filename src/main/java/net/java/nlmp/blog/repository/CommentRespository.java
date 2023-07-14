package net.java.nlmp.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.nlmp.blog.model.Comment;

public interface CommentRespository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByPostId(long postId);
	

}
