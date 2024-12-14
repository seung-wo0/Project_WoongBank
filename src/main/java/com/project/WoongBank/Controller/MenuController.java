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
			System.out.println("UserAccountCnt : " + UserAccountCnt);
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
		
		Random random = new Random();
		String AccountAdress = "7777"+ random.nextInt(100,999) + random.nextInt(100000,999999);
		if (UserPhoneSession != null || UserPhoneSession !="") {
			int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);
			model.addAttribute("UserAccountCnt", UserAccountCnt);
			model.addAttribute("AccountAdress", AccountAdress);
			
		}
		
		return "Account/Management/AccountCreate";
	}
	
	// 계좌관리 > 계좌생성 처리페이지
	@RequestMapping("/AccountCreateProc")
	public String mtdAccount_CreateProc (HttpServletRequest req, HttpSession session, Model model) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		String CreateAccountNumber = req.getParameter("CreateAccountNumber");
		String CreateAccountPassword = req.getParameter("CreateAccountPassword");

		//존재하는 계좌인지 체크
		int AccountAdressChk = accountSvc.CreateAccountChk(CreateAccountNumber);
		
		if (AccountAdressChk != 1) { //계좌가 존재하지 않는다면 해당계좌번호로 생성
			Map<String, Object> map = new HashMap<>();
			map.put("item1", UserIdSession);
			map.put("item2", CreateAccountNumber);
			map.put("item3", CreateAccountPassword);
			accountSvc.CreateAccountProc(map);
			model.addAttribute("ProcMsg", "계좌 생성이 완료 되었습니다!");
		} else { 
			System.out.println("존재한다면 들어오는곳");
			model.addAttribute("ProcMsg", "계좌 생성에 실패 하였습니다.");

		}
		
		return "Account/Management/AccountCreateProc";
	}
	
	// 계좌관리 > 계좌별칭변경 페이지
	@RequestMapping("/ChangedAccountName")
	public String mtd_ChangedAccountName (HttpServletRequest req, Model model) {
		String Account_Number  = req.getParameter("Account_Number");
		List<AccountDto> accountDto = accountSvc.UserAccountChangedInfo(Account_Number);
		model.addAttribute("UserAccountInfo", accountDto);
		System.out.println(Account_Number);
		return "Account/Management/ChangedAccountName";
	}
	
	// 계좌관리 > 계좌별칭변경 처리 페이지
	@RequestMapping("/ChangedAccountNameProc")
	public String mtd_ChangedAccountNameProc (HttpServletRequest req, Model model) {
		String UserAccountNumber = req.getParameter("UserAccountNumber");
		String ChangeAccountName = req.getParameter("Change_Account_name");
		System.out.println("별칭변경할 계좌번호 : " + UserAccountNumber);
		System.out.println("변경 요청 별칭 : " + ChangeAccountName);
		int updateChk = accountSvc.UpdateAccountName(UserAccountNumber, ChangeAccountName);
		String updateChkMsg = "변경 실패";
		if (updateChk == 1) updateChkMsg = "변경 완료";
		model.addAttribute("ChkMsg", updateChkMsg);
		return "Account/Management/ChangedAccountNameProc";
	}
	
	// 계좌관리 > 계좌삭제 페이지
	@RequestMapping("/AccountRemove")
	public String mtd_AccountRemove (HttpServletRequest req, Model model, HttpSession session) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		
		int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);

		if (UserAccountCnt != 0 ) {
			List<AccountDto> accountDto = accountSvc.UserAccountList(UserIdSession);
			model.addAttribute("UserAccountList", accountDto);
		}
		
		return "Account/Management/AccountRemove";
	}
	
	// 계좌관리 > 계좌삭제 페이지
	@RequestMapping("/SelectAccountRemoveProc")
	public String mtd_SelectAccountRemoveProc (HttpServletRequest req, Model model, HttpSession session) {
		String RemoveAccountNumber = (String) req.getParameter("SelectAccount");
		System.out.println("RemoveAccountNumber : " + RemoveAccountNumber);
		int RemoveAccountChk = accountSvc.RemoveUserAccount(RemoveAccountNumber);
		String RemoveChkMsg = "";
		if (RemoveAccountChk == 1) {
			RemoveChkMsg = "[ " +RemoveAccountNumber + " ]"+ "의 계좌가 삭제처리 되었습니다 !";
		} else {
			RemoveChkMsg = "[ " +RemoveAccountNumber + " ]"+ "의 계좌가 삭제처리에 실패 하였습니다!";
		}
		model.addAttribute("RemoveChkMsg", RemoveChkMsg);
		return "Account/Management/AccountRemoveProc";
	}
	
	// 입출금 페이지
	@RequestMapping("/Depo_With")
	public String mtdAccount_Depo_WithMain (HttpServletRequest req, Model model, HttpSession session) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		
		int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);

		if (UserAccountCnt != 0 ) {
			List<AccountDto> accountDto = accountSvc.UserAccountList(UserIdSession);
			model.addAttribute("UserAccountList", accountDto);
		}
		return "Account/Depo_With";
	}
	
	// 입·출금 페이지 현재잔액처리 Ajax
	@RequestMapping("/Account_Balance")
	public String mtd_Account_Balance (HttpServletRequest req, Model model, HttpSession session) {
		String account_number = req.getParameter("account_number");
		
		if (account_number != "" || account_number != null || account_number!= "0") {
			List<AccountDto> AccountDto = accountSvc.UserAccountChangedInfo(account_number);
			model.addAttribute("AccountDto", AccountDto);
		}
		return "Account/Depo_With/Account_Balance";
	}
	
	// 입·출금 처리 페이지
	@RequestMapping("/Depo_WithProc")
	public String mtd_Depo_With_DepoProc (HttpServletRequest req, Model model, HttpSession session) {
//		DW_SelectAccount=7777262876670&Depo_WithBox=on&Depo_WithChk=With&Now_account_balance=0&input_balance=011
		String account_number = req.getParameter("DW_SelectAccount"); // 입출금 거래의 계좌번호
		String Depo_WithChk = req.getParameter("Depo_WithChk"); // 입금인 지 출금인지의 여부
		int input_balance = Integer.parseInt(req.getParameter("input_balance")); // 거래할금액 받아오기
		String maybe_AccountBalance = req.getParameter("maybe_AccountBalance"); // 거래후 금액 체크
		
		Depo_WithChk = Depo_WithChk.equals("Depo") ? "입금" : "출금";
		
		input_balance = Depo_WithChk.equals("입금") ? input_balance : -input_balance;
		
		System.out.println("입출금 거래계좌: " + account_number);
		System.out.println("입금,출금여부 : " + Depo_WithChk);
		System.out.println("거래금액 : " + input_balance);
		System.out.println("거래 후 금액 : " + maybe_AccountBalance);
		return "Account/Depo_With/Depo_WithProc";
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
