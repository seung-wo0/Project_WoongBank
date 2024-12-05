package com.project.WoongBank.Dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDto {

	private int id; // 순서
	private String username; // 회원이름
	private String phone; // 전화번호
	private String password; // 비밀번호
	private int role; // 권한
	private Timestamp create_TM; // 가입일자
	private Timestamp modify_TM; //수정일자
	
}
