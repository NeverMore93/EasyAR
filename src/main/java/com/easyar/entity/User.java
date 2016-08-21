package com.easyar.entity;

import java.io.Serializable;

import lombok.Data;



@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6529571841517928721L;
	private String email;
	private String coupon;
}
