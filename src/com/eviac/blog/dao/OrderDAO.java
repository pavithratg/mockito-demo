package com.eviac.blog.dao;

import java.sql.SQLException;

import com.eviac.blog.dto.Order;

public interface OrderDAO {

	/**
	 * 
	 * @param order
	 * @return order id
	 * @throws SQLException
	 */
	int create(Order order) throws SQLException;

	/**
	 * 
	 * @param id
	 * @return order id
	 * @throws SQLException
	 */
	Order read(int id) throws SQLException;

	/**
	 * 
	 * @param order
	 * @return order id
	 * @throws SQLException
	 */
	int update(Order order) throws SQLException;

	/**
	 * 
	 * @param id
	 * @return order id
	 * @throws SQLException
	 */
	int delete(int id) throws SQLException;

}
