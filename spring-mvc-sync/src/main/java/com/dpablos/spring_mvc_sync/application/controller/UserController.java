package com.dpablos.spring_mvc_sync.application.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

	@Value("${order.url}")
	private String orderUrl;

	@GetMapping(value = "/user")
	public ResponseEntity<Void> getUserOrder(@RequestParam long delay) {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(String.format(this.orderUrl, delay)).build();
		try {
			client.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().build();
	}
}
