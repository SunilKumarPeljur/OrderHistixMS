/**
 * 
 */
package com.training.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.dao.Orders;
import com.training.service.OrderService;

/**
 * @author admin
 *
 */

@RestController
@RequestMapping("/api")
public class OrdersAPI {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/getAllOrders", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Orders>> getAllOrders() {
		List<Orders> orders = orderService.findAll();
		if(orders != null) {
			return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
		}
		return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
	}
}
