package com.project.WoongBank.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.WoongBank.Dto.AccountDto;
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

			if (UserAccountCnt != 0 ) {
				List<AccountDto> accountDto = accountSvc.UserAccountList(UserIdSession);
				model.addAttribute("UserAccountList", accountDto);
			}
		}
		
		return "Account/Management";
	}
	
	// 계좌관리 페이지
	@RequestMapping("/AccountCreate")
	public String mtdAccount_Create (HttpServletRequest req, HttpSession session, Model model) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		
		if (UserPhoneSession != null || UserPhoneSession !="") {
			int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);
			model.addAttribute("UserAccountCnt", UserAccountCnt);
			
		}
		
		return "Account/Management/AccountCreate";
	}
	
	// 계좌관리 > 계좌생성 처리페이지
	@RequestMapping("/AccountCreateProc")
	public String mtdAccount_CreateProc (HttpServletRequest req, HttpSession session, Model model) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		Random random = new Random();
		String AccountAdress = "7777"+ random.nextInt(100,999) + random.nextInt(100000,999999);
		
		System.out.println("전체 계좌 : " + AccountAdress);
		int AccountAdressChk = accountSvc.CreateAccountChk(AccountAdress);
		
		if (AccountAdressChk != 1) { //계좌가 존재하지 않는다면 해당계좌번호로 생성
			Map<String, Object> map = new HashMap<>();
			map.put("item1", UserIdSession);
			map.put("item2", AccountAdress);
			accountSvc.CreateAccountProc(map);

		} else { 
			System.out.println("존재한다면 들어오는곳");

		}
		
		return "Account/Management/AccountCreate";
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
