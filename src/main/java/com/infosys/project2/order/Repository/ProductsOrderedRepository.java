package com.infosys.project2.order.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infosys.project2.order.Entity.ProductsOrderedEntity;

@Repository
public interface ProductsOrderedRepository  extends JpaRepository<ProductsOrderedEntity, Integer>{
	ProductsOrderedEntity getOne(Integer orderId);

	ProductsOrderedEntity findByOrderId(Integer orderid);




}
