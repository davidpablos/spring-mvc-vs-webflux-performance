package com.dpablos.spring_mvc_sync.application.controller;

import com.dpablos.spring_mvc_sync.application.controller.dto.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

	@GetMapping(value = "${order.url}")
	public ResponseEntity<List<Order>> getOrder(@RequestParam long delay) throws InterruptedException {
		Thread.sleep(delay);

		return ResponseEntity.ok(
			List.of(
				new Order(1, "Water", "Mineral Water", 1.75),
				new Order(2, "Fish and chips", "Medium Fish and Chips",3.55)
			)
		);
	}

}
