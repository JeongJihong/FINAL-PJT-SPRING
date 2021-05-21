package com.ssafy.dto;

public class ArticleDTO {

	private int articleno;
	private String id;
	private String subject;
	private String content;
	private String regtime;

	
	public ArticleDTO() {
		super();
	}

	public ArticleDTO(int articleno, String id, String subject, String content, String regtime) {
		super();
		this.articleno = articleno;
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.regtime = regtime;
	}

	public int getArticleno() {
		return articleno;
	}

	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}

	public String getUserId() {
		return id;
	}

	public void setUserId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

}
