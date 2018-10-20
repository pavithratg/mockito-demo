package com.eviac.blog.bo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.eviac.blog.dao.OrderDAO;
import com.eviac.blog.dto.Order;
import com.eviac.blog.exceptions.BOException;

public class OrderBOImplTest {

	@Mock
	private OrderDAO dao;
	private OrderBOImpl bo;
	private Order order;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setOrderDao(dao);
		order = new Order();
	}

	/**
	 * positive scenario. test placeOrder method should create an order.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test
	public void placeOrder_should_create_an_order() throws SQLException, BOException {
		when(dao.create(order)).thenReturn(1);

		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao).create(order);
	}

	/**
	 * negative scenario. test placeOrder method should not create an order.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test
	public void placeOrder_should_not_create_an_order() throws SQLException, BOException {
		when(dao.create(order)).thenReturn(0);

		boolean result = bo.placeOrder(order);

		assertFalse(result);
		verify(dao).create(order);
	}

	/**
	 * exception scenario. test placeOrder method should throw an exception.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test(expected = BOException.class)
	public void placeOrder_should_throw_BOException() throws SQLException, BOException {
		when(dao.create(order)).thenThrow(SQLException.class);
		bo.placeOrder(order);
	}

}
