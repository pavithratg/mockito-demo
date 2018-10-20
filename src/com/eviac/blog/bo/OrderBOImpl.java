package com.eviac.blog.bo;

import java.sql.SQLException;

import com.eviac.blog.dao.OrderDAO;
import com.eviac.blog.dto.Order;
import com.eviac.blog.exceptions.BOException;

public class OrderBOImpl implements OrderBO {

	private OrderDAO orderDao;

	/**
	 * upon creating the order successfully, returns true.
	 */
	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = orderDao.create(order);

			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	/**
	 * searches the order according to the order id, changes the order status to
	 * Cancelled, updates the order. Upon successful cancellation returns true.
	 */
	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = orderDao.read(id);
			order.setStatus("Cancelled");
			int result = orderDao.update(order);

			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	/**
	 * deleted an order based on order id, upon successful deletion returns true.
	 */
	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = orderDao.delete(id);

			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public OrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

}
