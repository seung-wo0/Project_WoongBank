package com.project.WoongBank.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.WoongBank.Dto.UserDto;
import com.project.WoongBank.Service.UserSvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserSvc userSvc;
	
	//회원가입 페이지
	@RequestMapping("/Join")
	public String mtdJoinUser (HttpServletRequest req) {
		return "JoinUser";
	}
	
	//회원가입 처리
	@RequestMapping("/JoinProc")
	public String mtdJoinUserProc (HttpServletRequest req) {
		
		String JoinUserName = req.getParameter("JoinUserName");
		String JoinUserPhone = req.getParameter("JoinUserPhone1")+req.getParameter("JoinUserPhone2")+req.getParameter("JoinUserPhone3");
		String JoinUserPW = req.getParameter("JoinUserPW");
		
		System.out.println("JoinUserName : " + JoinUserName);
		System.out.println("JoinUserPhone : " + JoinUserPhone);
		System.out.println("JoinUserPW : " + JoinUserPW);
		
		return "redirect:/";
	}
	
	// 로그인 처리 
	@RequestMapping("/LoginProc")
	public String mtdLoginProc (HttpServletRequest req, HttpSession session) {
//		System.out.println("로그인처리 메서드 진입");
		String LoginID = req.getParameter("LoginID"); //사용자가 로그인시도한 아이디
		String LoginPW = req.getParameter("LoginPW"); //사용자가 로그인시도한 비밀번호
		Map<String, Object> map = new HashMap<>();
		int LoginChk = userSvc.LoginProc(LoginID, LoginPW); // 계정검증
		if (LoginChk == 1) { // 검증시 존재하다면
			UserDto userDto = userSvc.UserInfo(LoginID);
			session.setAttribute("UserSession", userDto.getPhone());	
			session.setAttribute("UserNameSession", userDto.getUsername());
			session.setMaxInactiveInterval(10*60*60);
			
			System.out.println(userDto);
			return "redirect:/index.sw";
		} else { // 검증시 존재하지않는다면
			return "redirect:/";
		}
	}
	
	// 로그아웃 페이지
	@RequestMapping("/Logout")
	public String mtdLogout (HttpServletRequest req, HttpSession session) {
		session = req.getSession();
		
		if (session != null) session.invalidate();
		return "redirect:/";
	}		
	
	
}
