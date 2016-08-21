package com.easyar.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class UserOrder implements Serializable {

	/**
	 * @author YUAN
	 */
	private static final long serialVersionUID = 8176306614299177356L;
	private String orderID;
	private String money;
	private String invitationCode;

}
