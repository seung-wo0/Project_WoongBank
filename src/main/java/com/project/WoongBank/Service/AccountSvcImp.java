package com.project.WoongBank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.WoongBank.Dao.AccountDao;

@Service
public class AccountSvcImp implements AccountSvc {
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public int UserAccountCnt(int UserIdSession) {
		return accountDao.UserAccountCnt(UserIdSession);
	}
	
}
