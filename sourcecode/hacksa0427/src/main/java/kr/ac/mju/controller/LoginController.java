package kr.ac.mju.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.mju.dto.LoginInfo;
import kr.ac.mju.dto.User;
import kr.ac.mju.service.LoginService;

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
	public String login(HttpServletRequest request){
		String view = null;
		LoginInfo info = new LoginInfo();
		info.setID(request.getParameter("userID"));
		info.setPassword(request.getParameter("userPassword"));
		User user = service.login(info);
		if (user != null) {
			request.getSession().setAttribute("userLoginSession", user);
			logger.info(user.getName() + "가 로그인하셨습니다!");
			if (user.getCategory().equals("학생")) {
				view = "hacksaengpage";
			} else if (user.getCategory().equals("교수")) {
				view = "gyosupage";
			}
		} else {
			logger.info("로그인실패");
			view = "redirect:/";
		}
		return view;
	}

	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("userLoginSession");
		logger.info("로그아웃 요청");
		return "redirect:/";
	}
}
