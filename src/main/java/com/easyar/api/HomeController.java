package com.easyar.api;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import com.easyar.model.ResultInfo;
import com.easyar.util.AsyncHttpClientUtil;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ResultInfo test(String username) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(1000);
		resultInfo.setMsg("OK");
		resultInfo.setData(username);
		return resultInfo;
	}
	
	
	
	
	
	@RequestMapping(value = "/addImage", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo AddImage(String name,String image) {
		String ResultString=null;
		ResultInfo resultInfo = new ResultInfo();
		try {
			ResultString = AsyncHttpClientUtil.AddImage(name, image);
		} catch (JSONException | IOException | InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			resultInfo.setCode(1003);
			resultInfo.setMsg("error");
			resultInfo.setData("");	 		
	 		return resultInfo;
		}
		
		resultInfo.setCode(1000);
		resultInfo.setMsg("OK");
		resultInfo.setData(ResultString);
 		
 		return resultInfo;
	}
	
	@RequestMapping(value = "/similarImage", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo SimilarImage(String image) {
		String ResultString=null;
		ResultInfo resultInfo = new ResultInfo();
		try {
			ResultString = AsyncHttpClientUtil.SimilarImage(image);
		} catch (JSONException | IOException | InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block

			resultInfo.setCode(1003);
			resultInfo.setMsg("error");
			resultInfo.setData("");	 		
	 		return resultInfo;
		}

		resultInfo.setCode(1000);
		resultInfo.setMsg("OK");
		resultInfo.setData(ResultString);
 		
 		return resultInfo;
	}
	
	@RequestMapping(value = "/detectImage", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo DetectImage(String image) {
		String ResultString=null;
		ResultInfo resultInfo = new ResultInfo();
		try {
			ResultString = AsyncHttpClientUtil.DetectImage(image);
		} catch (JSONException | IOException | InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block

			resultInfo.setCode(1003);
			resultInfo.setMsg("error");
			resultInfo.setData("");	 		
	 		return resultInfo;
		}

		resultInfo.setCode(1000);
		resultInfo.setMsg("OK");
		resultInfo.setData(ResultString);
 		
 		return resultInfo;
	}
	
	
	
}
