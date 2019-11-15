package com.model2.mvc.service.domain;

import java.sql.Date;

public class Review {
	
	private Date regDate;
	private String userReview;
	private int prodNo;
	private String userId;
	
	public Review() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUserReview() {
		
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview.replace("undefined,", "");
	}
	
	public String toString() {
		return "userId : " + userId + ", prodNo : " + prodNo + ", userReview : " + userReview + ", regDate : " + regDate;
		
	}
	
}
