package com.project.WoongBank.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.WoongBank.Dto.UserDto;

@Mapper
public interface UserDao {
	
	
	//로그인 처리 메서드
	int LoginProc (String LoginID, String LoginPW);
	
	//회원 정보 가져오기
	UserDto UserInfo (String LoginID);
}
