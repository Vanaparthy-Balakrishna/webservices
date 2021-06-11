package com.bala.rest.webservices.user;

public class Post {

	private Integer postId;
	private Integer userId;
	private String message;
	public Post(int postId, int userId, String message) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.message = message;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
