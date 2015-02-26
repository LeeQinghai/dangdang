package com.qinghai.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.qinghai.dao.UserDao;
import com.qinghai.model.Users;

public class UserDaoImpl implements UserDao{
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Users getUserById(Integer id) {
		return (Users) hibernateTemplate.get(Users.class, id);
	}
	
	public Users getUserByUserId(String userId){
		List<Users> listUsers = (List<Users>) hibernateTemplate.find("from Users u where u.userId = ?", userId);
		if(listUsers.size()==0) {
			return null;
		} 
		return listUsers.get(0);
	}
	
	public List<Users> getUserList() {
		List<Users> listUsers = (List<Users>) hibernateTemplate.find("from Users u");
		return listUsers;
	}
	
	public Integer save(Users user) {
		return (Integer) hibernateTemplate.save(user);
	}
	
}
