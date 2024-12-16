package com.project.WoongBank.Service;

import java.util.List;
import java.util.Map;

import com.project.WoongBank.Dto.TransactionDto;

public interface TransactionSvc {
	
	// 입·출금 거래내역 업데이트(추가)
	int Account_Balance_add(Map<String, Object> map);
	
	// 계좌에따른 입출금 거래내역 리스트
	List<TransactionDto> AccountTransactionList(int Account_Number);

}