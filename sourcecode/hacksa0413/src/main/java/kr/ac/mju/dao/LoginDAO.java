package kr.ac.mju.dao;

import kr.ac.mju.controller.LoginInfo;
import kr.ac.mju.dto.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginDAO.class);
	private final static String USERDATAFILEPATH = "userdata.txt";

	public User login(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		String userID = loginInfo.getID();
		String userPassword = loginInfo.getPassword();
		
		
		return null;

	}
}
