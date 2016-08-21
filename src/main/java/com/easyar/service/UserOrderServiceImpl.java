package com.easyar.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyar.constant.ResultInfoConstants;
import com.easyar.dao.UserOrderMapper;
import com.easyar.entity.UserOrder;
import com.easyar.model.ResultInfo;


@Service("userOrderService")
public class UserOrderServiceImpl implements UserOrderService {
	
	@Resource
    private	UserOrderMapper userOrderMapper;
	
	@Override
	public ResultInfo addUser(UserOrder userOrder) {
		ResultInfo resultInfo = new ResultInfo();
//		try {
//			userOrderMapper.add(userOrder);
//			resultInfo.setCode(ResultInfoConstants.SUCCESS);
//			resultInfo.setData(userOrder);
//			resultInfo.setMsg("添加成功");
//			return resultInfo;
//			
//		} catch (Exception e) {
//			resultInfo.setCode(ResultInfoConstants.FAIL);
//			resultInfo.setData(null);
//			resultInfo.setMsg("添加失败");
//			return resultInfo;
//		}
		
		userOrderMapper.add(userOrder);
		resultInfo.setCode(ResultInfoConstants.SUCCESS);
		resultInfo.setData(userOrder);
		resultInfo.setMsg("添加成功");
		return resultInfo;
		
		
		
		
	}

}
