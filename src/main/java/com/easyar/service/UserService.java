package com.easyar.service;

import com.easyar.entity.User;
import com.easyar.model.ResultInfo;

public interface UserService {
	public ResultInfo addUser(User user);
	public ResultInfo findCouponByEmail(String email);
	public ResultInfo findEmailByCoupon(String coupon);
}
