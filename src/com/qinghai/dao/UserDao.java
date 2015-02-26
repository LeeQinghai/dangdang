package com.qinghai.dao;

import java.util.List;

import com.qinghai.model.Users;

public interface UserDao {
	public Users getUserById(Integer id);
	public Users getUserByUserId(String userId);
	public List<Users> getUserList();
	public Integer save(Users user);
}
