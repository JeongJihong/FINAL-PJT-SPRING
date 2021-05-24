package com.ssafy.dto;

public class ShopDataDTO {
	private String type;
	private String count;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	public ShopDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShopDataDTO(String type, String count) {
		super();
		this.type = type;
		this.count = count;
	}
}
