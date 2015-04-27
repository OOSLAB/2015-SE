package kr.ac.mju.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.dao.LoginDAO;
import kr.ac.mju.dto.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
	private static final Logger logger = LoggerFactory
			.getLogger(LoginService.class);
	public User login(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			return dao.login(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
