package com.easyar.dao;

import java.util.List;

import com.easyar.entity.User;




public interface UserDao {
	
	public void add(User user);
	public User findUserByEmail(String email);
	public List<User> findUserByCoupon(String coupon);	
}
