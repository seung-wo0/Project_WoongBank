package com.project.WoongBank.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.WoongBank.Dao.AccountDao;
import com.project.WoongBank.Dto.AccountDto;

@Service
public class AccountSvcImp implements AccountSvc {
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public int UserAccountCnt(int UserIdSession) {
		return accountDao.UserAccountCnt(UserIdSession);
	}
	
	@Override
	public int CreateAccountChk(String AccountAdress) {
		return accountDao.CreateAccountChk(AccountAdress);
	}
	
	@Override
	public int CreateAccountProc(Map<String, Object> map) {
		return accountDao.CreateAccountProc(map);
	}
	
	@Override
	public List<AccountDto> UserAccountList(int user_id) {

		return accountDao.UserAccountList(user_id);
	}
	
	@Override
	public List<AccountDto> UserAccountChangedInfo(String Account_Number) {
		return accountDao.UserAccountChangedInfo(Account_Number);
	}
	
	@Override
	public int UpdateAccountName(String UserAccountNumber, String ChangeAccountName) {
		return accountDao.UpdateAccountName(UserAccountNumber, ChangeAccountName);
	}
}
