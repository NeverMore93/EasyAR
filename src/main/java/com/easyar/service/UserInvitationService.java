package com.easyar.service;

import com.easyar.entity.UserInvitation;
import com.easyar.model.ResultInfo;

public interface UserInvitationService {
	public ResultInfo add(UserInvitation userInvitation);
	public ResultInfo findUserByID(String userID);
	
}
