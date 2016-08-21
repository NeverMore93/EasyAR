package com.easyar.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInvitation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8176306614299177356L;
	private String userID;
	private String invitationCode;

}
