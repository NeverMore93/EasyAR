package com.easyar.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyar.dao.UserDao;
import com.easyar.entity.User;
import com.easyar.model.ResultInfo;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public ResultInfo addUser(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(1000); 
		resultInfo.setData(user);
		resultInfo.setMsg("查询完毕");		
		return resultInfo;
	}

	public ResultInfo findCouponByEmail(String email) {
		// TODO Auto-generated method stub
		
		User user= userDao.findUserByEmail(email);
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(1000); 
		resultInfo.setData(user);
		resultInfo.setMsg("查询完毕");			
		return resultInfo;
	}

	public ResultInfo findEmailByCoupon(String coupon) {
		// TODO Auto-generated method stub
		ResultInfo resultInfo = new ResultInfo();
		List<User> list = userDao.findUserByCoupon(coupon);
		resultInfo.setCode(1000); 
		resultInfo.setData(list);
		resultInfo.setMsg("查询完毕");	
		return resultInfo;
	}

	

}
