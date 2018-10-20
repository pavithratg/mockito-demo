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

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * test placeOrder method should create an order
	 * 
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void placeOrder_should_create_an_order() throws SQLException, BOException {
		OrderBOImpl bo = new OrderBOImpl();
		bo.setOrderDao(dao);

		Order order = new Order();
		when(dao.create(order)).thenReturn(1);

		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao).create(order);
	}

}
