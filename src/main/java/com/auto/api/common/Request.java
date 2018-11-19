package com.auto.api.common;

import org.springframework.data.annotation.Id;

public abstract class Request {
	@Id
	private String requestId;
	
	private Object bodyGet;
	
	private Object bodyPost;
	
	private String link;

	public String getRequestId() {
		return requestId;
	}

	public Object getBodyGet() {
		return bodyGet;
	}



	public void setBodyGet(Object bodyGet) {
		this.bodyGet = bodyGet;
	}



	public Object getBodyPost() {
		return bodyPost;
	}



	public void setBodyPost(Object bodyPost) {
		this.bodyPost = bodyPost;
	}



	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
