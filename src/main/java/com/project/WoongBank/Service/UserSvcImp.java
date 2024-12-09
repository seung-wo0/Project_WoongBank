package com.project.WoongBank.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.WoongBank.Dao.UserDao;
import com.project.WoongBank.Dto.UserDto;

@Service
public class UserSvcImp implements UserSvc {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public int LoginProc(String LoginID, String LoginPW) {
		return userDao.LoginProc(LoginID, LoginPW);
	}
	
	@Override
	public UserDto UserInfo(String LoginID) {
		return userDao.UserInfo(LoginID);
	}
	
}
