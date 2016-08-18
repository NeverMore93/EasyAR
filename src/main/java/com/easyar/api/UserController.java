package com.easyar.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyar.entity.User;
import com.easyar.model.ResultInfo;
import com.easyar.service.UserService;



@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/text2")
	@ResponseBody
    public ResultInfo execute(String email){
        ResultInfo ri = userService.findCouponByEmail(email);
        System.out.println(ri);
		return ri;
    }
	
	@RequestMapping("/au")
	@ResponseBody
	public ResultInfo execute(User user){
		ResultInfo ri = userService.addUser(user);
		System.out.println(ri);
		return ri;
	}
	
	@RequestMapping("/fubc")
	@ResponseBody
	public ResultInfo execute1(String coupon){
		ResultInfo ri = userService.findEmailByCoupon(coupon);
		System.out.println(ri);
		return ri;
	}
	
	@RequestMapping("/fube")
	@ResponseBody
	public ResultInfo execute2(String email){
		ResultInfo ri = userService.findCouponByEmail(email);
		System.out.println(ri);
		return ri;
	}
}
