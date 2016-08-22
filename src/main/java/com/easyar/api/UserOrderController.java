package com.easyar.api;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.easyar.constant.ResultInfoConstants;
import com.easyar.entity.UserInvitation;
import com.easyar.entity.UserOrder;
import com.easyar.exception.IllegalUserIDException;
import com.easyar.exception.ReAddUserInvitationException;
import com.easyar.exception.UserIDNoFindException;
import com.easyar.model.ResultInfo;
import com.easyar.service.UserInvitationService;
import com.easyar.service.UserOrderService;
@Controller
public class UserOrderController {
	
	@Resource
	private UserInvitationService userInvitationService;
	
	@Resource
	private UserOrderService userOrderService;
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="/aui", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
    public ResultInfo addUserInvitation(UserInvitation userInvitation){
		ResultInfo resultInfo=null;
		if(!userInvitation.getUserID().matches("[a-z0-9_-]{36}")){
			throw new IllegalUserIDException();
		}
		
		try {
			 resultInfo = userInvitationService.add(userInvitation);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ReAddUserInvitationException("添加失败",e);
		}
        
		return resultInfo;
    }
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="/fubi", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
    public ResultInfo findUserByInvitation(String userID){
        ResultInfo resultInfo =null;
        
        try {
        	resultInfo = userInvitationService.findUserByID(userID);
		} catch (Exception e) {
			throw new UserIDNoFindException("查询失败",e);
		}
		return resultInfo;
    }
	
	@ResponseStatus(value=HttpStatus.OK)
	@RequestMapping(value="/auo", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
    public ResultInfo addUserOrder(UserOrder userOrder){
        ResultInfo resultInfo = userOrderService.addUser(userOrder);
		return resultInfo;
    }
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ReAddUserInvitationException.class)
	@ResponseBody
    public ResultInfo ReAddUserInvitation(){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultInfoConstants.FAIL);
        resultInfo.setMsg("已存在，不要重复添加");
        resultInfo.setData(null);
		return resultInfo;
    }
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserIDNoFindException.class)
	@ResponseBody
    public ResultInfo UserIDNoFind(){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultInfoConstants.FAIL);
        resultInfo.setMsg("查询失败");
        resultInfo.setData(null);
		return resultInfo;
    }
	
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalUserIDException.class)
	@ResponseBody
    public ResultInfo IllegalUserID(){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultInfoConstants.FAIL);
        resultInfo.setMsg("无效的userID");
        resultInfo.setData(null);
		return resultInfo;
    }
	
	
	
	
	
	
}
