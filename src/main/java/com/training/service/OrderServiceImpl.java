/**
 * 
 */
package com.training.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.training.dao.Orders;
import com.training.dao.OrdersRepository;

/**
 * @author admin
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepository ordersRepo;
	
	@Override
	@HystrixCommand(fallbackMethod="findAllFallback")
	public List<Orders> findAll() {
		return ordersRepo.findAll();
	}
	
	public List<Orders> findAllFallback() {
		List<Orders> orders = new ArrayList<Orders>();
		orders.add(new Orders(-1000, "Dummy fall back from hystrix", new Date(), false, -999999));
		return orders;
	}

}
