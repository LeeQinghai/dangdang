package com.qinghai.service;

import java.util.List;

import com.qinghai.model.Users;

public interface UserService {
	public Users getUserById(Integer id);
	public Users getUserByUserId(String userId);
	public List<Users> getUserList();
	public Integer addUser(String userId, String userName, String password, 
			String phone, String email, String picUrl);
}
