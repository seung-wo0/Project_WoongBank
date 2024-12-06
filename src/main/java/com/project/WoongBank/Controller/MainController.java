package com.project.WoongBank.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.WoongBank.Dto.UserDto;
import com.project.WoongBank.Service.UserSvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	UserSvc userSvc; 
	
	// 홈페이지 처음 로그인페이지
	@RequestMapping("/")
	public String mtdLogin () {
		
		return "Login";
	}
	
	// 홈페이지 처음 로그인페이지
	@RequestMapping("/LoginProc")
	public String mtdLoginProc (HttpServletRequest req, HttpSession session) {
//		System.out.println("로그인처리 메서드 진입");
		String LoginID = req.getParameter("LoginID"); //사용자가 로그인시도한 아이디
		String LoginPW = req.getParameter("LoginPW"); //사용자가 로그인시도한 비밀번호
		Map<String, Object> map = new HashMap<>();
		int LoginChk = userSvc.LoginProc(LoginID, LoginPW); // 계정검증
		if (LoginChk == 1) { // 검증시 존재하다면
			UserDto userDto = userSvc.UserInfo(LoginID);
			session.setAttribute("UserSession", userDto.getId());	
			session.setAttribute("UserNameSession", userDto.getId());
			session.setMaxInactiveInterval(10*60*60);
			
			System.out.println(userDto);
			return "redirect:/index.sw";
		} else { // 검증시 존재하지않는다면
			return "redirect:/";
		}
		
	}
	
	// 홈페이지 메인
	@RequestMapping("/index.sw")
	public String mtdIndex () {
		
		return "Index";
	}
	
	// 로그아웃 페이지
	@RequestMapping("/Logout")
	public String mtdLogout (HttpServletRequest req, HttpSession session) {
		session = req.getSession();
		
		if (session != null) session.invalidate();
		return "redirect:/";
	}
	

}
