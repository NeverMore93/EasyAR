package com.easyar.dao;

import com.easyar.entity.UserInvitation;

public interface UserInvitationMapper {
	public void add(UserInvitation userInvitation);
	public UserInvitation findUserByID(String userID);
}
