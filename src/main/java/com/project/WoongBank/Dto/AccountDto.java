package com.project.WoongBank.Dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AccountDto {
	int id;// 순서
    int user_id; // user테이블id
    String bank	; // 은행이름
    String account_number; // 계좌번호
    String account_name; //	 계좌이름(별칭)
    int account_balance; // 계좌잔액
    Timestamp account_create_TM; // 계좌개설날짜
    Timestamp account_modify_TM; // 계좌수정날짜
    Timestamp account_delete_TM; // 계좌삭제날짜
}
