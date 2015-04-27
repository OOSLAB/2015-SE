package kr.ac.mju.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.dto.Gangjwa;
import kr.ac.mju.service.GangjwaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GangwaController {
	@Autowired
	private GangjwaService service;

	@RequestMapping(value = "/gangjwaController/gaeseolPage", method = RequestMethod.GET)
	public String gaeseolPage() {
		return "gaeseol";
	}

	@RequestMapping(value = "/gangjwaController/sugangPage", method = RequestMethod.GET)
	public ModelAndView sugangPage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("sugang");
		ArrayList<Gangjwa> gangjwaList = service.getGangjwaList(request);
		view.addObject("gangjwaList", gangjwaList);
		return view;
	}

	@RequestMapping(value = "/gangjwaController/sugang.do", method = RequestMethod.POST)
	public String requestForSugang(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		service.requestForSugang(request);
		return "redirect:/gangjwaController/sugangPage";
	}
	
	@RequestMapping(value = "/gangjwaController/gaeseol.do", method = RequestMethod.POST)
	public String gangjwaGaeseol(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		service.gangjwaGaeseol(request);
		return "redirect:/gangjwaController/gaeseolPage";
	}
}
