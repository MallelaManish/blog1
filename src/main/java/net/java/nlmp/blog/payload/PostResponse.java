package net.java.nlmp.blog.payload;

import java.util.List;

import lombok.Data;

@Data
public class PostResponse {
	
	private List<PostDto> content;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean last;
}
