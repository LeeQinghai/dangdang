package com.qinghai.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.qinghai.model.Users;
import com.qinghai.service.UserService;

public class UserAction extends BaseAction {
	
	private UserService userService;
	
	private List<Users> userList;
	
	/*register user*/
	private String userId;
	private String userName;
	private String phone;
	private String password;
	private String email;
	private String picUrl;
	
	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String userList() {
		if(this.getMe()==null) {
			return Action.ERROR;
		}
		userList = userService.getUserList();
		
		return Action.SUCCESS;
	}
	
	public String registerUser() {
		
		String method = getRequest().getMethod();
		if(method!=null && method.equals("GET")) {
			return "register";
		}
		
		if(userId==null || userId.equals("")) {
			return Action.ERROR;
		}
		if(password==null || password.equals("")) {
			return Action.ERROR;
		}
		Integer id = userService.addUser(userId, userName, password, phone, email, picUrl);
		if(id==null) {
			return Action.ERROR;
		}
		System.out.println("flag: " + id);
		rememberMe(userService.getUserById(id));
		return Action.SUCCESS;
	}
	
}
