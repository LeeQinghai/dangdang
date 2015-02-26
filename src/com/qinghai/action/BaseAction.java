package com.qinghai.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qinghai.model.Users;

public class BaseAction extends ActionSupport {
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private String path =request.getContextPath();
	private String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";;
	private HttpSession session = request.getSession();
	private Users me = (Users) session.getAttribute("user");
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public Users getMe() {
		return me;
	}
	public void setMe(Users me) {
		this.me = me;
	}
	public boolean isLogin() {
		if(session.getAttribute("user")!=null) {
			return true;
		}
		return false;
	}
	
	public void rememberMe(Users user) {
		this.setMe(user);
		getSession().setAttribute("user", user);
		Cookie cookie = new Cookie("id",user.getUserId());
		cookie.setMaxAge(1000000000);
		getResponse().addCookie(cookie);
	}
	
}
