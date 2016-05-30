package com.fm.dto;

import java.sql.Timestamp;

public class BuyingDTO {
	private int num;
	private String id;
	private int price;
	
	private Timestamp times;
	
	
	public Timestamp getTimes() {
		return times;
	}
	public void setTimes(Timestamp times) {
		this.times = times;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
