package com.ssafy.dto;

public class QnaDTO {

	private int qnano;
	private String id;
	private String subject;
	private String content;
	private String regtime;
	private String answer;

	
	public QnaDTO() {
		super();
	}

	public QnaDTO(int qnano, String id, String subject, String content, String regtime, String answer) {
		super();
		this.qnano = qnano;
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.regtime = regtime;
		this.answer = answer;
	}

	public int getQnAno() {
		return qnano;
	}

	public void setQnAno(int qnano) {
		this.qnano = qnano;
	}

	public int getQnano() {
		return qnano;
	}

	public void setQnano(int qnano) {
		this.qnano = qnano;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
