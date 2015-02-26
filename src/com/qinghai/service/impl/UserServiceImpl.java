package com.qinghai.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.qinghai.dao.UserDao;
import com.qinghai.model.Users;
import com.qinghai.service.UserService;
import com.qinghai.util.Util;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public Users getUserById(Integer id) {
		return userDao.getUserById(id);
	}
	
	public Users getUserByUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}
	
	public List<Users> getUserList() {
		return userDao.getUserList();
	}
	
	public Integer addUser(String userId, String userName, String password, 
				String phone, String email, String picUrl) {
		
		Users user = new Users();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(Util.getMD5(password));
		user.setPhone(phone);
		user.setEmail(email);
		user.setPicUrl(picUrl);
		user.setState(1);
		user.setCreateDt(new Date());
		user.setCreateId(userId);
		
		return userDao.save(user);
	}
}
