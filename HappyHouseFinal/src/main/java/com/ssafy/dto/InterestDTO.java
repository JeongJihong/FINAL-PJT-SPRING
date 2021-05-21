package com.ssafy.dto;

public class InterestDTO {
	private String id;
	private String dong;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	
	public InterestDTO() {
		super();
	}
	
	public InterestDTO(String id, String dong) {
		super();
		this.id = id;
		this.dong = dong;
	}
}
