package com.project.WoongBank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.WoongBank.Dao.UserDao;

@Service
public class UserSvcImp implements UserSvc {
	
	@Autowired
	UserDao userDao;
	
}
