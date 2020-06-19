package com.infosys.project2.order.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.project2.order.DTO.ProductsOrderedDTO;
import com.infosys.project2.order.Entity.OrderEntity;



@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

	OrderEntity getOne(Integer orderId);

	OrderEntity findByOrderId(Integer orderid);

//	OrderEntity findById(Integer id);



	

}
