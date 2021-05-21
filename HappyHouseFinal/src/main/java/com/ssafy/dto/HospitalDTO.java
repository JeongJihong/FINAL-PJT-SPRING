package com.ssafy.dto;

public class HospitalDTO {
	private String	dong;
	private String 	hname;
	private String 	haddr;
	private String 	htype;
	private String 	htel;
	
	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}
	
	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHaddr() {
		return haddr;
	}

	public void setHaddr(String haddr) {
		this.haddr = haddr;
	}

	public String getHtype() {
		return htype;
	}

	public void setHtype(String htype) {
		this.htype = htype;
	}

	public String getHtel() {
		return htel;
	}

	public void setHtel(String htel) {
		this.htel = htel;
	}

	public HospitalDTO(String dong, String hname, String haddr, String htype, String htel) {
		super();
		this.dong = dong;
		this.hname = hname;
		this.haddr = haddr;
		this.htype = htype;
		this.htel = htel;
	}

	public HospitalDTO() {
		super();
	}
	
	
	
}
