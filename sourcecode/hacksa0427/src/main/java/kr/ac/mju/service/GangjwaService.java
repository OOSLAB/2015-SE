package kr.ac.mju.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.dao.PlainDAO;
import kr.ac.mju.dto.Gangjwa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GangjwaService {

	@Autowired
	private PlainDAO dao;
	
	public ArrayList<Gangjwa> getGangjwaList(HttpServletRequest request) {
		// TODO Auto-generated method stub
//		return dao.getGangjwaList(request);
		return null;
	}

	public void requestForSugang(HttpServletRequest request) {
		// TODO Auto-generated method stub
//		dao.requestForSugang(request);
	}

	public void gangjwaGaeseol(HttpServletRequest request) {
		// TODO Auto-generated method stub
//		dao.gangjwaGaeseol(request);
	}

}
