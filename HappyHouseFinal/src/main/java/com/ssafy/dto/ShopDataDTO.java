package com.ssafy.dto;

public class ShopDataDTO {
	private String city;
	private String gugun;
	private String dong;
	private String type;
	private String count;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
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
	public ShopDataDTO(String city, String gugun, String dong, String type, String count) {
		super();
		this.city = city;
		this.gugun = gugun;
		this.dong = dong;
		this.type = type;
		this.count = count;
	}
}
