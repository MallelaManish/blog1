package net.java.nlmp.blog.payload;

import lombok.Data;

@Data
public class PostDto {
	
	private long id;
	private String title;
	private String description;
	private String  content;
	
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDto(long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getContent() {
		return content;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
