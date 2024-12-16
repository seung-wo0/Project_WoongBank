package com.project.WoongBank.Service;

import java.util.List;
import java.util.Map;

import com.project.WoongBank.Dto.AccountDto;

public interface AccountSvc {
	
	//유저의 id로 갖고있는 계좌갯수 체크 메서드
	int UserAccountCnt(int UserIdSession);
	
	// 계좌생성시 존재하는계좌번호체크 메서드
	int CreateAccountChk(String AccountAdress);
	
	// 계좌생성 처리 메서드
	int CreateAccountProc(Map<String, Object> map);
	
	// 보유계좌 리스트출력 메서드
	List<AccountDto> UserAccountList(int user_id);
	
	// 계좌별칭변경을 위한 정보 불러오기 메서드
	List<AccountDto> UserAccountChangedInfo(String Account_Number);
	
	// 계좌별칭변경 처리 메서드
	int UpdateAccountName(String UserAccountNumber, String ChangeAccountName);
	
	// 계좌삭제 처리 메서드
	int RemoveUserAccount(String RemoveAccountNumber);
	
	// 계좌와비밀번호 일치여부반환 메서드
	int Account_PasswordChk(String Account_Number, String Account_Password);
	
	// 입·출금 처리 메서드
	int Account_BalanceUpdate(String Account_Number, String maybe_AccountBalance);
}
