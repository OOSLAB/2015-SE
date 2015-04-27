package kr.ac.mju.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.dto.Gangjwa;
import kr.ac.mju.dto.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GangjwaDAO extends DAO {
	private static final Logger logger = LoggerFactory
			.getLogger(GangjwaDAO.class);

	public ArrayList<Gangjwa> getGangjwaList(HttpServletRequest request) {
		// TODO Auto-generated method stub

		
		ArrayList<Gangjwa> gangjwaList = new ArrayList<Gangjwa>();

		String path = request.getSession().getServletContext()
				.getRealPath(GANGJWA_DATA_FILE);
		File file = new File(path);

		logger.info(file.getPath());
		String s;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			while ((s = in.readLine()) != null) {
				String[] gangjwaLine = s.split(SPLIT_SEPERATOR);
				Gangjwa gangjwa = new Gangjwa();
				gangjwa.setID(gangjwaLine[0]);
				gangjwa.setName(gangjwaLine[1]);
				gangjwaList.add(gangjwa);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gangjwaList;
	}

	public void requestForSugang(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String gangjwaID = request.getParameter("gangjwaID");
		User userLoginSession = (User) request.getSession().getAttribute(
				"userLoginSession");
		String studentID = userLoginSession.getID();

		String path = request.getSession().getServletContext()
				.getRealPath(SUGANG_DATA_FILE);
		File file = new File(path);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.newLine();
			out.write(studentID + SPLIT_SEPERATOR + gangjwaID);
			out.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void gangjwaGaeseol(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		String gangjwaID = request.getParameter("gangjwaID");
		String gangjwaName = request.getParameter("gangjwaName");
		logger.info("개설할강좌:"+gangjwaName);
		String path = request.getSession().getServletContext()
				.getRealPath(GANGJWA_DATA_FILE);
		File file = new File(path);
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			out.write(gangjwaID + SPLIT_SEPERATOR + gangjwaName);
			out.newLine();
			out.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
