package com.example.websocket.vo;

import java.util.List;

public class D1 {
//	private String planTime;
	private List<String> flightNo;
	private String toCityZH;
	private String counterNo;
	private String statusZH;
	public List<String> getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(List<String> flightNo) {
		this.flightNo = flightNo;
	}
	public String getToCityZH() {
		return toCityZH;
	}
	public void setToCityZH(String toCityZH) {
		this.toCityZH = toCityZH;
	}
	public String getCounterNo() {
		return counterNo;
	}
	public void setCounterNo(String counterNo) {
		this.counterNo = counterNo;
	}
	public String getStatusZH() {
		return statusZH;
	}
	public void setStatusZH(String statusZH) {
		this.statusZH = statusZH;
	}
}
