package com.library.audit.domain;

public class Audit {
	private String id;
	
	private String orderId;
	
	private String userId;
	
	private String creditCardLastFour;
	
	private String creationDate;
	
	public Audit(String orderId, String userId, String creditCardLastFour, String creationDate) {
		this.orderId = orderId;
		this.userId = userId;
		this.creditCardLastFour = creditCardLastFour;
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCreditCardLastFour() {
		return creditCardLastFour;
	}

	public void setCreditCardLastFour(String creditCardLastFour) {
		this.creditCardLastFour = creditCardLastFour;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
}
