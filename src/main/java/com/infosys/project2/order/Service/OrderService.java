package com.infosys.project2.order.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.project2.order.DTO.OrderDTO;
import com.infosys.project2.order.DTO.ProductDTO;
import com.infosys.project2.order.DTO.ProductsOrderedDTO;
import com.infosys.project2.order.Entity.OrderEntity;
import com.infosys.project2.order.Entity.ProductsOrderedEntity;
import com.infosys.project2.order.Repository.OrderRepository;
import com.infosys.project2.order.Repository.ProductsOrderedRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository order;

	@Autowired
	ProductsOrderedRepository orders;
	

	public List<OrderDTO> getorders() {
		List<OrderDTO> l=new ArrayList<OrderDTO>();
		List<OrderEntity> oe=order.findAll();
		for(OrderEntity o: oe) {
		OrderDTO O=OrderDTO.valueof(o);
		l.add(O);
		}
		return l;
	}


	public OrderDTO getordersbyid(Integer id) {
		OrderEntity oe=order.getOne(id);
		OrderDTO O=OrderDTO.valueof(oe);
		return O;
	}


	public List<ProductsOrderedDTO> getproductorders() {
		List<ProductsOrderedDTO> l=new ArrayList<ProductsOrderedDTO>();
		List<ProductsOrderedEntity> oe=orders.findAll();
		for(ProductsOrderedEntity o: oe) {
		ProductsOrderedDTO O=ProductsOrderedDTO.valueof(o);
		l.add(O);
		}
		return l;
	}


	public ProductsOrderedDTO getprodordersbyid(Integer orderid) {
		ProductsOrderedEntity oe=orders.getOne(orderid);
		ProductsOrderedDTO O=ProductsOrderedDTO.valueof(oe);
		return O;
	}


	public void removeorder(Integer orderid) {
		OrderEntity oe=order.findByOrderId(orderid);
		order.delete(oe);
		
	}
	
	public void removeorders(Integer orderid) {
		ProductsOrderedEntity oe=orders.findByOrderId(orderid);
		orders.delete(oe);
		
	}
	
	public void addToOrder(ProductDTO prodDTO,Integer quantity) {
		System.out.println("in service");
		ProductsOrderedDTO productOrderDTO= new ProductsOrderedDTO();
		productOrderDTO.setOrderId(productOrderDTO.getOrderId());
		productOrderDTO.setPrice(prodDTO.getPrice());
		productOrderDTO.setQuantity(quantity);
		productOrderDTO.setProdId(prodDTO.getProdid());
		productOrderDTO.setSellerId(prodDTO.getSellerId());
		productOrderDTO.setStatus("Order Placed");
		System.out.println(productOrderDTO);
		System.out.println("after Dto");
		
		ProductsOrderedEntity productOrder=productOrderDTO.createEntity(productOrderDTO);
		System.out.println("after entity");
		System.out.println(productOrder);
		orders.save(productOrder);
		}}
		
	
	
//	public ProductsOrderedDTO getvieworder(Integer orderid) {
//		ProductsOrderedDTO orders=null;
//		Optional<ProductsOrderedEntity> oe=order.findAllById(orderid);
//		if(oe!=null) {
//			  orders= ProductsOrderedDTO.valueof(oe);
//			
//				
//		}  return orders;
//		
//}}
