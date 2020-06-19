package com.infosys.project2.order.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productsordered")
public class ProductsOrderedEntity {
	@Id
	@GeneratedValue
	@Column(name="ORDERID", nullable = false)
	int orderId;
	@Column(name="PRODID", nullable = false)
	int prodId;
	@Column(name="SELLERID", nullable = false)
	int sellerId;
	@Column(name="QUANTITY", nullable = false)
	int quantity;
	@Column(name="STATUS", nullable = false)
	String status;
	@Column(name="PRICE")
	double price;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
