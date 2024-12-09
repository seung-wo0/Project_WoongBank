package com.project.WoongBank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.WoongBank.Service.AccountSvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {
	
	@Autowired
	AccountSvc accountSvc;
	
	// 계좌관리 페이지
	@RequestMapping("/Management")
	public String mtdAccount_ManagementMain (HttpServletRequest req, HttpSession session, Model model) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		
		if (UserPhoneSession != null || UserPhoneSession !="") {
			int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);
			model.addAttribute("UserAccountCnt", UserAccountCnt);
			
		}
		
		return "Account/Management";
	}
	
	// 입출금 페이지
	@RequestMapping("/Depo_With")
	public String mtdAccount_Depo_WithMain () {
		
		return "Account/Depo_With";
	}
	
	// 송금 페이지
	@RequestMapping("/Remittance")
	public String mtdAccount_RemittanceMain () {
		
		return "Account/Remittance";
	}
	
	// 거래내역 페이지
	@RequestMapping("/Tran_History")
	public String mtdAccount_Tran_HistoryMain () {
		
		return "Account/Tran_History";
	}
	
}
