package com.dpablos.spring_mvc_sync.application.controller.dto;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

	@Test
	void when_order_is_created_then_data_can_be_retrieved() {
		Order order = new Order(2, "::name::", "::description::", 23.3);

		assertEquals(2, order.id());
		assertEquals("::name::", order.name());
		assertEquals("::description::", order.description());
		assertEquals(23.3, order.price());
	}

}