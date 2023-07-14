package net.java.nlmp.blog.payload;

import java.util.Set;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
	
	private long id;
	
	@NotEmpty
	@Size(min = 2,message ="post should have atlest 2 characters")
	private String title;
	
	@NotBlank
	@Size(min =10,message = "post should have atlest 10 characters")
	private String description;
	
	@NotBlank
	private String  content;
	
	private Set<CommentDto> comments;

}
