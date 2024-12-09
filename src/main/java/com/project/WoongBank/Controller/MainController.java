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
	
	// 홈페이지 메인
	@RequestMapping("/index.sw")
	public String mtdIndex () {
		
		return "Index";
	}
	

}
