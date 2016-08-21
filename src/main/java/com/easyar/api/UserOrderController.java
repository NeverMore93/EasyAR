package com.easyar.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyar.entity.UserInvitation;
import com.easyar.entity.UserOrder;
import com.easyar.model.ResultInfo;
import com.easyar.service.UserInvitationService;
import com.easyar.service.UserOrderService;
@Controller
public class UserOrderController {
	
	@Resource
	private UserInvitationService userInvitationService;
	
	@Resource
	private UserOrderService userOrderService;
	
	
	@RequestMapping(value="/aui", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
    public ResultInfo addUserInvitation(UserInvitation userInvitation){
        ResultInfo resultInfo = userInvitationService.add(userInvitation);
		return resultInfo;
    }
	
	@RequestMapping(value="/fubi", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
    public ResultInfo findUserByInvitation(String userID){
        ResultInfo resultInfo = userInvitationService.findUserByID(userID);
		return resultInfo;
    }
	
	
	@RequestMapping(value="/auo", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
    public ResultInfo addUserOrder(UserOrder userOrder){
        ResultInfo resultInfo = userOrderService.addUser(userOrder);
		return resultInfo;
    }
	
	
	
	
}
