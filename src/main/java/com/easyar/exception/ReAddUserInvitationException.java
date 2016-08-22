package com.easyar.exception;



import com.easyar.model.ResultInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ReAddUserInvitationException extends RuntimeException {

	/**
	 * @author YUAN
	 */
	private static final long serialVersionUID = 4557566515075121503L;
	
	
	public ReAddUserInvitationException(String msg,Throwable t){
		super(msg,t);
	}
	

}
