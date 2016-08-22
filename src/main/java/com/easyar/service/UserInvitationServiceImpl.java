package com.easyar.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyar.constant.ResultInfoConstants;
import com.easyar.dao.UserInvitationMapper;
import com.easyar.entity.UserInvitation;
import com.easyar.exception.ReAddUserInvitationException;
import com.easyar.model.ResultInfo;


@Service("userInvitationService")
public class UserInvitationServiceImpl implements UserInvitationService{
	
	@Resource
	private UserInvitationMapper userInvitationMapper;
	
	@Override
	public ResultInfo add(UserInvitation userInvitation) {
			ResultInfo resultInfo = new ResultInfo();
			userInvitationMapper.add(userInvitation);
			resultInfo.setCode(ResultInfoConstants.SUCCESS);
			resultInfo.setData(userInvitation);
			resultInfo.setMsg("添加成功");
			return resultInfo;
	}

	@Override
	public ResultInfo findUserByID(String userID) {
		ResultInfo resultInfo = new ResultInfo();
		UserInvitation userInvitation = userInvitationMapper.findUserByID(userID);
		if(userInvitation==null){
			resultInfo.setCode(ResultInfoConstants.FAIL);
			resultInfo.setData(null);
			resultInfo.setMsg("不存在用户");
			
		}
		System.out.println(userInvitation.toString()+"test");
		resultInfo.setCode(ResultInfoConstants.SUCCESS);
		resultInfo.setData(userInvitation);
		resultInfo.setMsg("查询成功");	
		return resultInfo;
	}

}
