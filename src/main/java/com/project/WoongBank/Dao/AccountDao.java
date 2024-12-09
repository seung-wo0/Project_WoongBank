package com.project.WoongBank.Dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao {
	
	//유저의 id로 갖고있는 계좌갯수 체크 메서드
	int UserAccountCnt(int UserIdSession);
	
}
