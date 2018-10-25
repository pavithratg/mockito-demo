package com.eviac.blog.mockito.partialmock;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PartialMockDemo {

	// need to provide the implementation class, since interface doesn't provide
	// implementation while calling real methods.
	@Mock
	ArrayList<String> names;

	@Before
	public void setup() {
		// initializing the mocks.
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * test cases demonstrating partial mocks.
	 */
	@Test
	public void testPartialMock() {
		// stubbed.
		Mockito.when(names.get(0)).thenReturn("bob");

		// calls the real method on mocked object and return the value, not stubbed
		// value.
		Mockito.when(names.size()).thenCallRealMethod();
		assertSame("bob", names.get(0));
		assertSame(0, names.size());
	}

}
