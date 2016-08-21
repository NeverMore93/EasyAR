package com.easyar.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyar.constant.ResultInfoConstants;
import com.easyar.dao.UserInvitationMapper;
import com.easyar.entity.UserInvitation;
import com.easyar.model.ResultInfo;


@Service("userInvitationService")
public class UserInvitationServiceImpl implements UserInvitationService{
	
	@Resource
	private UserInvitationMapper userInvitationMapper;
	
	@Override
	public ResultInfo add(UserInvitation userInvitation) {
		ResultInfo resultInfo = new ResultInfo();
		UserInvitation userInvitation2 = userInvitationMapper.findUserByID(userInvitation.getUserID());
		if(userInvitation2==null){
			userInvitationMapper.add(userInvitation);
			resultInfo.setCode(ResultInfoConstants.SUCCESS);
			resultInfo.setData(userInvitation);
			resultInfo.setMsg("��ӳɹ�");
			return resultInfo;
		}
		resultInfo.setCode(ResultInfoConstants.FAIL);
		resultInfo.setData(userInvitation);
		resultInfo.setMsg("�Ѵ��ڣ������ظ����");
		return resultInfo;
	}

	@Override
	public ResultInfo findUserByID(String userID) {
		ResultInfo resultInfo = new ResultInfo();
		UserInvitation userInvitation = userInvitationMapper.findUserByID(userID);
		if(userInvitation==null){
			resultInfo.setCode(ResultInfoConstants.FAIL);
			resultInfo.setData("");
			resultInfo.setMsg("�������û�");
		}
		
		resultInfo.setCode(ResultInfoConstants.SUCCESS);
		resultInfo.setData(userInvitation);
		resultInfo.setMsg("��ѯ�ɹ�");	
		return resultInfo;
	}

}
