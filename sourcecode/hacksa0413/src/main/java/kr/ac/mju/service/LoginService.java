package kr.ac.mju.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.mju.controller.LoginInfo;
import kr.ac.mju.dto.*;
import kr.ac.mju.dao.*;
@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
	private static final Logger logger = LoggerFactory
			.getLogger(LoginService.class);
	public User login(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		logger.info("서비스는 가냥?  왓느냐???");
		return dao.login(loginInfo);
	}
	
	
}
