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
	
	@Override
	public int RemoveUserAccount(String RemoveAccountNumber) {
		return accountDao.RemoveUserAccount(RemoveAccountNumber);
	}
	
	@Override
	public int Account_PasswordChk(String Account_Number, String Account_Password) {
		return accountDao.Account_PasswordChk(Account_Number, Account_Password);
	}
	
	@Override
	public int Account_BalanceUpdate(String Account_Number, String maybe_AccountBalance) {
		return accountDao.Account_BalanceUpdate(Account_Number, maybe_AccountBalance);
	}
}
