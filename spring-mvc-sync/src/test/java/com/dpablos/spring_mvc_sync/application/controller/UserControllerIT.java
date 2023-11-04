package com.dpablos.spring_mvc_sync.application.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void when_get_user_order_is_invoked_then_ok_response_is_returned() throws Exception {
		MockHttpServletResponse response = this.mockMvc.perform(
			MockMvcRequestBuilders
				.get("http://localhost:8081/user?delay=10")
				.contentType(MediaType.APPLICATION_JSON)
		).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}