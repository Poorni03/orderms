package com.infosys.project2.order.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.project2.order.DTO.OrderDTO;
import com.infosys.project2.order.DTO.ProductDTO;
import com.infosys.project2.order.DTO.ProductsOrderedDTO;
import com.infosys.project2.order.Service.OrderService;


@RestController
@RequestMapping(value="/order")
@EnableAutoConfiguration
@CrossOrigin
public class OrderController {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		
		@Autowired
		public OrderService orderservice;
		
		@Autowired
		public RestTemplate template;
		
	
		
		@GetMapping(value="/view", produces= MediaType.APPLICATION_JSON_VALUE)
		public List<OrderDTO> getorders(){
			List<OrderDTO> orderDto=orderservice.getorders();
			return orderDto;
			}

		@GetMapping(value="/view/{orderid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public OrderDTO getordersbyid(@PathVariable Integer orderid){
			logger.info("Request for Order view by Buyer {}", orderid);
			OrderDTO orderDto=orderservice.getordersbyid(orderid);
			return orderDto;
			}
		
		@GetMapping(value="/productview", produces= MediaType.APPLICATION_JSON_VALUE)
		public List<ProductsOrderedDTO> getproductorders(){
			List<ProductsOrderedDTO> orderDto=orderservice.getproductorders();
			return orderDto;
			}
		
		@GetMapping(value="/productview/{orderid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public ProductsOrderedDTO getprodordersbyid(@PathVariable Integer orderid){
			logger.info("Request for Product Ordered view by Buyer {}", orderid);
			ProductsOrderedDTO orderDto=orderservice.getprodordersbyid(orderid);
			return orderDto;
			}
		
		@DeleteMapping(value="/remove/{orderid}", consumes= MediaType.APPLICATION_JSON_VALUE)
		public String removeorder(@PathVariable Integer orderid) {
			logger.info("Request for order removal by buyer {}", orderid);
			orderservice.removeorder(orderid);
			return "Deleted successfully";
			
		}
		
		@DeleteMapping(value="/prodremove/{orderid}", consumes= MediaType.APPLICATION_JSON_VALUE)
		public String removeorders(@PathVariable Integer orderid) {
			logger.info("Request for order removal by buyer {}", orderid);
			orderservice.removeorders(orderid);
			return "Deleted successfully";
		
		}
		
		@PostMapping(value="/add/products/{prodid}/{quantity}",  consumes= MediaType.APPLICATION_JSON_VALUE)
		public String addToOrder(@PathVariable Integer prodid,@PathVariable Integer quantity) {
			try {
				logger.info("Add products to wishlist request {}", prodid);
				ProductDTO prodDTO=template.getForObject("http://PRODUCTMS"+"/products/productid/"+prodid,ProductDTO.class);
				System.out.println("before service");
				orderservice.addToOrder(prodDTO,quantity);
				System.out.println("after service");
				return "Added to order successfully";
			}catch(Exception e) {
				return "Unable to add";
			}
		}
}
		
		
		
