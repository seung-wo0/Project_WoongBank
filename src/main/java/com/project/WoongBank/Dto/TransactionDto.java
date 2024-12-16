package com.project.WoongBank.Dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TransactionDto {	
	
	int id;// 순서
    int account_id;// account테이블id
    String transaction;// 거래타입(입,출,송금)
    int amount;// 거래금액
    int amount_balance;// 거래 후 잔액
    String deposit_name;// 입금자명
    String withdrawal_name;// 출금자명
    String receive_name;// 송금계좌주명
    String receive_account;// 송금계좌번호
    Timestamp transaction_TM;// 거래일자
	
}
