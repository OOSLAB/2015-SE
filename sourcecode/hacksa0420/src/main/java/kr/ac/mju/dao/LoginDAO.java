package kr.ac.mju.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.dto.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO extends DAO{
	private static final Logger logger = LoggerFactory
			.getLogger(LoginDAO.class);


	public User login(HttpServletRequest request) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String path = request.getSession().getServletContext()
				.getRealPath(USER_DATA_FILE);
		File file = new File(path);

		logger.info(file.getPath());
		BufferedReader in = new BufferedReader(new FileReader(file));
		String s;
		while ((s = in.readLine()) != null) {
			String[] userInfo = s.split(SPLIT_SEPERATOR);
			if (userInfo[0].equals(userID) && userInfo[1].equals(userPassword)) {
				User user = new User();
				user.setID(userInfo[0]);
				user.setPassword(userInfo[1]);
				user.setName(userInfo[2]);
				user.setCategory(userInfo[3]);
				return user;
			}
		}

		return null;

	}
}
