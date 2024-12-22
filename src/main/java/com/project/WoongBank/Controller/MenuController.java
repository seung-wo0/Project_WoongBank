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
import com.project.WoongBank.Dto.TransactionDto;
import com.project.WoongBank.Service.AccountSvc;
import com.project.WoongBank.Service.TransactionSvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {
	
	@Autowired
	AccountSvc accountSvc;
	
	@Autowired
	TransactionSvc transactionSvc;
	
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
		String account_number = req.getParameter("DW_SelectAccount"); // 입출금 거래의 계좌번호
		String Depo_WithChk = req.getParameter("Depo_WithChk"); // 입금인 지 출금인지의 여부
		int input_balance = Integer.parseInt(req.getParameter("input_balance")); // 거래할금액 받아오기
		String maybe_AccountBalance = req.getParameter("maybe_AccountBalance"); // 거래후 금액 체크
		String input_Account_Password = req.getParameter("input_Account_Password"); // 계좌비밀번호
		String passwordChk_msg = "";
		int passwordChk = accountSvc.Account_PasswordChk(account_number, input_Account_Password);
		Depo_WithChk = Depo_WithChk.equals("Depo") ? "입금" : "출금";
		input_balance = Depo_WithChk.equals("입금") ? input_balance : -input_balance;
		
		if (passwordChk == 1) {
			List<AccountDto> accountDto = accountSvc.UserAccountChangedInfo(account_number);
			Map<String, Object> map = new HashMap<>();
			map.put("item1", accountDto.get(0).getId());
			map.put("item2", Depo_WithChk);
			map.put("item3", input_balance);
			map.put("item4", maybe_AccountBalance);
			if (Depo_WithChk.equals("입금")) {
				map.put("item5", "본인");
				map.put("item6", "");
			} else {
				map.put("item5", "");
				map.put("item6", "본인");
			}
			transactionSvc.Account_Balance_add(map);
			accountSvc.Account_BalanceUpdate(account_number, maybe_AccountBalance);
			passwordChk_msg = Depo_WithChk + " 을 완료 하였습니다.";
		} else {
			passwordChk_msg = Depo_WithChk + " 을 실패 하였습니다. 계좌 비밀번호를 확인해주세요";
		}
		model.addAttribute("passwordChk_msg", passwordChk_msg);
		System.out.println("입출금 거래계좌: " + account_number);
		System.out.println("입금,출금여부 : " + Depo_WithChk);
		System.out.println("거래금액 : " + input_balance);
		System.out.println("거래 후 금액 : " + maybe_AccountBalance);
		System.out.println("계좌 비번 : "+  input_Account_Password);
		
		System.out.println("passwordChk_msg : " + passwordChk_msg);
		return "Account/Depo_With/Depo_WithProc";
	}
	
	
	// 송금 페이지
	@RequestMapping("/Remittance")
	public String mtdAccount_RemittanceMain (HttpServletRequest req, Model model, HttpSession session) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		
		int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);
	
		if (UserAccountCnt != 0 ) {
			List<AccountDto> accountDto = accountSvc.UserAccountList(UserIdSession);
			model.addAttribute("UserAccountList", accountDto);
		}
		return "Account/Remittance";
	}
	
	// 송금계좌 체크
	@RequestMapping("/Receive_Account_Chk")
	public String mtdReceive_Account_Chk (HttpServletRequest req, Model model, HttpSession session) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		String Receive_Account_Chk = req.getParameter("Receive_Account_Chk");
//		int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);
		// 계좌가 모든회원계좌에서 존재하는지 여부 체크
		int ReceiveAccountChk = accountSvc.CreateAccountChk(Receive_Account_Chk);
		System.out.println("ReceiveAccountChk : " + ReceiveAccountChk);
		String ReceiveAccountChkMsg = "";
		if (ReceiveAccountChk != 0 ) {
			ReceiveAccountChkMsg = "이체 가능";
		} else {
			ReceiveAccountChkMsg = "이체 불가능";
		}
		model.addAttribute("ReceiveAccountChkMsg", ReceiveAccountChkMsg);
		return "Account/Remittance/receive_account_Chk";
	}
	// 송금계좌 체크
	@RequestMapping("/Receive_AccountPW_Chk")
	public String mtdReceive_AccountPW_Chk (HttpServletRequest req, Model model, HttpSession session) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		String Receive_Account_Chk = req.getParameter("Receive_Account_Chk");
//		int passwordChk = accountSvc.Account_PasswordChk(account_number, input_Account_Password);
		// 계좌가 모든회원계좌에서 존재하는지 여부 체크
		int ReceiveAccountChk = accountSvc.CreateAccountChk(Receive_Account_Chk);
		System.out.println("ReceiveAccountChk : " + ReceiveAccountChk);
		String ReceiveAccountChkMsg = "";
		if (ReceiveAccountChk != 0 ) {
			ReceiveAccountChkMsg = "이체 가능";
		} else {
			ReceiveAccountChkMsg = "이체 불가능";
		}
		model.addAttribute("ReceiveAccountChkMsg", ReceiveAccountChkMsg);
		return "Account/Remittance/receive_accountPW_Chk";
	}
	
	// 거래내역 메인 페이지
	@RequestMapping("/Tran_History")
	public String mtdAccount_Tran_HistoryMain (HttpServletRequest req, Model model, HttpSession session) {
		int UserIdSession = (int) session.getAttribute("UserIdSession");
		String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
		String UserNameSession = (String) session.getAttribute("UserNameSession");
		
		int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);

		if (UserAccountCnt != 0 ) {
			List<AccountDto> accountDto = accountSvc.UserAccountList(UserIdSession);
			model.addAttribute("UserAccountList", accountDto);
		}
		return "Account/Tran_History";
	}
	
	// 거래내역 메인 페이지
		@RequestMapping("/Tran_History_List")
		public String mtdAccount_Tran_History_List (HttpServletRequest req, Model model, HttpSession session) {
			int UserIdSession = (int) session.getAttribute("UserIdSession");
			String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
			String UserNameSession = (String) session.getAttribute("UserNameSession");
			int UserAccountCnt = accountSvc.UserAccountCnt(UserIdSession);
			
			int Account_id =  Integer.parseInt(req.getParameter("account_id"));
			System.out.println(Account_id);
			List<TransactionDto> transactionDto = transactionSvc.AccountTransactionList(Account_id);
				model.addAttribute("AccountTransactionList", transactionDto);
			if (UserAccountCnt != 0 ) {
//				List<AccountDto> accountDto = accountSvc.UserAccountList(UserIdSession);
				
			}
			
			return "Account/Transaction/Tran_History_List";
		}
	
}
