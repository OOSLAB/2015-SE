package kr.ac.mju.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.dao.PlainDAO;
import kr.ac.mju.dto.LoginInfo;
import kr.ac.mju.dto.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
	
	@Autowired
	private PlainDAO dao;
	private static final Logger logger = LoggerFactory
			.getLogger(LoginService.class);
	public User login(LoginInfo info) {
		// TODO Auto-generated method stub
	return null;
	}
	
	
	
}
