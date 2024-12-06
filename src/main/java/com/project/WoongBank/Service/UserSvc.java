package com.project.WoongBank.Service;

import java.util.List;
import java.util.Map;

import com.project.WoongBank.Dto.UserDto;

public interface UserSvc {
	
	//로그인 처리 메서드
	int LoginProc (String LoginID, String LoginPW);
	
	//회원 정보 가져오기
	UserDto UserInfo (String LoginID);
	
}
