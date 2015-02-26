package com.qinghai.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.qinghai.model.Users;
import com.qinghai.service.UserService;
import com.qinghai.util.Util;

public class LoginAction extends BaseAction {	
	
	private String userId;
	private String password;
	private String userName;
	private UserService userService;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		
		if(this.isLogin()) {
			return Action.SUCCESS;
		}

		if(userId==null || userId.equals("")) {
			return Action.ERROR;
		}
		
		if(password==null || password.equals("")) {
			return Action.ERROR;
		}

		Users user = userService.getUserByUserId(userId);
		if(user==null) {
			System.out.println("null");
			return Action.ERROR;
		}
		if(user.getPassword()!=null && !user.getPassword().equals(Util.getMD5(password))) {
			return Action.ERROR;
		}
				
		rememberMe(user);
		
		return Action.SUCCESS;
	}
	
	public String logout() {
		this.setMe(null);
		getSession().setAttribute("user", null);
		return Action.SUCCESS;
	}
}
