package com.infosys.project2.order.DTO;

import com.infosys.project2.order.Entity.ProductsOrderedEntity;

public class ProductsOrderedDTO {
	int orderId;
	int prodId;
	int sellerId;
	int quantity;
	String status;
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
	
	public static ProductsOrderedDTO valueof(ProductsOrderedEntity prod) {
		ProductsOrderedDTO productsOrderDTO=new ProductsOrderedDTO();
		productsOrderDTO.setOrderId(prod.getOrderId());
		productsOrderDTO.setProdId(prod.getProdId());
		productsOrderDTO.setPrice(prod.getPrice());
		productsOrderDTO.setQuantity(prod.getQuantity());
		productsOrderDTO.setSellerId(prod.getSellerId());
		productsOrderDTO.setStatus(prod.getStatus());
		return productsOrderDTO;
	}

	public ProductsOrderedEntity createEntity(ProductsOrderedDTO productOrderDTO) {
		System.out.println("in entity");
		ProductsOrderedEntity productsOrder=new ProductsOrderedEntity();
		productsOrder.setOrderId(productOrderDTO.getOrderId());
		productsOrder.setPrice(productOrderDTO.getPrice());
		productsOrder.setProdId(productOrderDTO.getProdId());
		productsOrder.setQuantity(productOrderDTO.getQuantity());
		productsOrder.setSellerId(productOrderDTO.getSellerId());
		productsOrder.setStatus("Order Placed");
		return productsOrder;
		
		
	}}


