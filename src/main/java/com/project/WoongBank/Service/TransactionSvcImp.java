package com.project.WoongBank.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.WoongBank.Dao.TransactionDao;
import com.project.WoongBank.Dto.TransactionDto;

@Service
public class TransactionSvcImp implements TransactionSvc {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public int Account_Balance_add(Map<String, Object> map) {
		return transactionDao.Account_Balance_add(map);
	}
	
	@Override
	public List<TransactionDto> AccountTransactionList(int Account_Number) {
		return transactionDao.AccountTransactionList(Account_Number);
	}
	
}
