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

	private static final int ORDER_ID = 123;
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

	/**
	 * positive scenario. test cancelOrder method should cancel an order.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test
	public void cancelOrder_should_cancel_order() throws SQLException, BOException {
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);

		boolean result = bo.cancelOrder(ORDER_ID);

		assertTrue(result);
		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}

	/**
	 * negative scenario. test cancelOrder method should not cancel an order.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test
	public void cancelOrder_should_not_cancel_order() throws SQLException, BOException {
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);

		boolean result = bo.cancelOrder(ORDER_ID);

		assertFalse(result);
		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}

	/**
	 * exception scenario. test cancelOrder method should throw a BOException upon
	 * read.
	 * 
	 * @throws BOException
	 * @throws SQLException custom exception
	 */
	@Test(expected = BOException.class)
	public void cancelOrder_should__throw_BOException_on_read() throws BOException, SQLException {
		when(dao.read(ORDER_ID)).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);
	}

	/**
	 * exception scenario. test cancelOrder method should throw a BOExceptionupon
	 * update.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test(expected = BOException.class)
	public void cancelOrder_should_throw_BOException_on_update() throws SQLException, BOException {
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);

	}

	/**
	 * positive scenario. test deleteOrder method should delete and order.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test
	public void deleteOrder_should_delete_an_order() throws SQLException, BOException {
		when(dao.delete(ORDER_ID)).thenReturn(1);

		boolean result = bo.deleteOrder(ORDER_ID);
		assertTrue(result);
		verify(dao).delete(ORDER_ID);
	}

	/**
	 * negative scenario. test deleteOrder method should not delete and order.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test
	public void deleteOrder_should_not_delete_an_order() throws SQLException, BOException {
		when(dao.delete(ORDER_ID)).thenReturn(0);

		boolean result = bo.deleteOrder(ORDER_ID);
		assertFalse(result);
		verify(dao).delete(ORDER_ID);
	}

	/**
	 * exception scenario. test deleteOrder method should throw BOException.
	 * 
	 * @throws SQLException
	 * @throws BOException  custom exception
	 */
	@Test(expected = BOException.class)
	public void deleteOrder_should_throw_BOException() throws SQLException, BOException {
		when(dao.delete(ORDER_ID)).thenThrow(SQLException.class);
		bo.deleteOrder(ORDER_ID);
	}

}
