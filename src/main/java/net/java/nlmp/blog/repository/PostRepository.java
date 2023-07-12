package net.java.nlmp.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.nlmp.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	//spring jpa write all sql

}
