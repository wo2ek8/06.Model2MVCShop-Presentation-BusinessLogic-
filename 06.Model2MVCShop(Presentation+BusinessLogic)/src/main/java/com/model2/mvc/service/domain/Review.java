package com.model2.mvc.service.domain;

import java.sql.Date;

public class Review {
	
	private Date regDate;
	private String userReview;
	private int prodNo;
	private User reviewer;
	
	public Review() {
		
	}

	
	


	





	

	public User getReviewer() {
		return reviewer;
	}













	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
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
		return "reviewer : " + reviewer + ", prodNo : " + prodNo + ", userReview : " + userReview + ", regDate : " + regDate;
		
	}
	
}
