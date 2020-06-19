package com.infosys.project2.order.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class OrderEntity {
	@Id
	@GeneratedValue
	@Column(name="ORDERID", nullable = false)
	int orderId;
	@Column(name="BUYERID", nullable = false)
	int buyerId;
	@Column(name="AMOUNT", nullable = false)
	float amount;
	@Column(name="DATE", nullable = false)
	Date date;
	@Column(name="ADDRESS", nullable = false)
	String address;
	@Column(name="STATUS", nullable = false)
	String status;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
