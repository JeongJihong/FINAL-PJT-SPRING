package com.ssafy.dto;

public class HousePageBean {
	private int no;
	private String city;
	private String code;
	private String dongcode;
	private String gugun;
	private String dong;
	private String lat;
	private String lng;
	
	public HousePageBean(int no, String city, String code, String dongcode, String gugun, String dong, String lat,
			String lng) {
		super();
		this.no = no;
		this.city = city;
		this.code = code;
		this.dongcode = dongcode;
		this.gugun = gugun;
		this.dong = dong;
		this.lat = lat;
		this.lng = lng;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
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

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
	
}
