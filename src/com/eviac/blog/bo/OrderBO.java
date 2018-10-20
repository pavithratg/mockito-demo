package com.eviac.blog.bo;

import com.eviac.blog.dto.Order;
import com.eviac.blog.exceptions.BOException;

public interface OrderBO {

	/**
	 * @param order
	 * @return true if order created successfully.
	 * @throws BOException
	 */
	boolean placeOrder(Order order) throws BOException;

	/**
	 * @param order
	 * @return true if order cancelled successfully.
	 * @throws BOException
	 */
	boolean cancelOrder(int id) throws BOException;

	/**
	 * @param order
	 * @return true if order deleted successfully.
	 * @throws BOException
	 */
	boolean deleteOrder(int id) throws BOException;

}
