package com.ssafy.dto;

public class EnvCheckDTO {
	private String coName;
	private String coType;
	private String checkDate;
	private String hasProblem;
	private String checkDetail;
	private String dong;
	private String coAddr;
	
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoType() {
		return coType;
	}
	public void setCoType(String coType) {
		this.coType = coType;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getHasProblem() {
		return hasProblem;
	}
	public void setHasProblem(String hasProblem) {
		this.hasProblem = hasProblem;
	}
	public String getCheckDetail() {
		return checkDetail;
	}
	public void setCheckDetail(String checkDetail) {
		this.checkDetail = checkDetail;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getCoAddr() {
		return coAddr;
	}
	public void setCoAddr(String coAddr) {
		this.coAddr = coAddr;
	}
	
	public EnvCheckDTO() {
		super();
	}
	
	public EnvCheckDTO(String coName, String coType, String checkDate, String hasProblem, String checkDetail,
			String dong, String coAddr) {
		super();
		this.coName = coName;
		this.coType = coType;
		this.checkDate = checkDate;
		this.hasProblem = hasProblem;
		this.checkDetail = checkDetail;
		this.dong = dong;
		this.coAddr = coAddr;
	}
}
