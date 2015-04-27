package kr.ac.mju.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import kr.ac.mju.service.*;
import kr.ac.mju.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws UnsupportedEncodingException {
			request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");		
		LoginInfo loginInfo = new LoginInfo(userID, userPassword);
		
		logger.info("로그인요청 : "+userID+","+userPassword);
		logger.info(request.getContextPath());
		
		User user = service.login(loginInfo);
		if(user != null){		
		request.getSession().setAttribute("userLoginSession", user);
		return "sugang";
		}else{
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("userLoginSession");
		logger.info("로그아웃 요청");
		return "redirect:/";
	}
}
