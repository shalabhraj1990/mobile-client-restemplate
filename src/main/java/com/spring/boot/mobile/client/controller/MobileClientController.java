package com.spring.boot.mobile.client.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.mobile.client.model.Mobile;

@RestController
@RequestMapping("mobile-client")
public class MobileClientController {
	@Autowired
	private RestTemplate restMobieTemplate;

	@GetMapping("{mobile-id}")
	public ResponseEntity<Mobile> getMobilesByIdFromMobileService(@PathVariable("mobile-id") int id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(restMobieTemplate.getForObject("http://localhost:8080/mobile/" + id, Mobile.class));
	}
	
	@GetMapping
	public ResponseEntity<List<Mobile>> getAllMobiles() throws RestClientException, URISyntaxException{
		ResponseEntity<List<Mobile>>  responseEntity = restMobieTemplate.exchange(new URI("http://localhost:8080/mobile"), HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Mobile>>(){});
		return responseEntity;
	}
 
}
