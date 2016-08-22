package com.easyar.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class ResultInfo implements Serializable{

	/**
	 * @author YUAN
	 */
	
	private static final long serialVersionUID = 848066731952165867L;
	private Integer code;
	private String msg;
	private Object data;	

}
