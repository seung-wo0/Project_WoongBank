package com.project.WoongBank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	// 홈페이지 처음 로그인페이지
	@RequestMapping("/")
	public String mtdLogin () {
		
		return "Login";
	}
	
	// 홈페이지 처음 로그인페이지
	@RequestMapping("/LoginProc")
	public void mtdLoginProc () {
		
		
	}
	
	// 홈페이지 메인
	@RequestMapping("/index.sw")
	public String mtdIndex () {
		
		return "Index";
	}
	

}
