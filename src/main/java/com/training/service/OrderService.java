/**
 * 
 */
package com.training.service;

import java.util.List;

import com.training.dao.Orders;

/**
 * @author admin
 *
 */
public interface OrderService {
	
	public List<Orders> findAll();

}
