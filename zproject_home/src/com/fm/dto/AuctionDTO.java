package com.fm.dto;

import java.sql.Timestamp;

public class AuctionDTO {
	private int num;
	private String id;
	private String title;
	private String contents;
	private String imgs;
	private String category;
	private String name;
	private String pr;
	private int startPrice;
	private int nowPrice;
	private int bidIncrease;
	private int bidCount;
	private Timestamp reg_date;
	private int days;
	private Timestamp dayLast;
	private int counts;
	private int state;
	private String maxBuy;
	
	
	public String getMaxBuy() {
		return maxBuy;
	}
	public void setMaxBuy(String maxBuy) {
		this.maxBuy = maxBuy;
	}
	public int getBidCount() {
		return bidCount;
	}
	public void setBidCount(int bidCount) {
		this.bidCount = bidCount;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPr() {
		return pr;
	}
	public void setPr(String pr) {
		this.pr = pr;
	}
	public int getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}
	public int getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(int nowPrice) {
		this.nowPrice = nowPrice;
	}
	
	public int getBidIncrease() {
		return bidIncrease;
	}
	public void setBidIncrease(int bidIncrease) {
		this.bidIncrease = bidIncrease;
	}
	
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Timestamp getDayLast() {
		return dayLast;
	}
	public void setDayLast(Timestamp dayLast) {
		this.dayLast = dayLast;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
		
	
}