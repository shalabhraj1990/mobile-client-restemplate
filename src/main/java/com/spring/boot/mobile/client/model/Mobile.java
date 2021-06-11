package com.spring.boot.mobile.client.model;

import lombok.Data;

@Data
public class Mobile {
	private String accessoryType;
	private String countryCode;
	private int id;
	private String lob;
	private String name;
	private double price;
	private String publicationDate;
	private String status;
}
