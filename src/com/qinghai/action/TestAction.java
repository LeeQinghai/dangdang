package com.qinghai.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private Cookie[] cookies;
	
	public Cookie[] getCookies() {
		return cookies;
	}
	public void setCookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public String test(){
		cookies = request.getCookies();
		Cookie cookie = new Cookie(Math.random()+"",Math.random()+"");
		cookie.setMaxAge(1000000000);
		response.addCookie(cookie);
		
		HttpSession session = request.getSession();
		/*
		if(session==null) {
			System.out.println("session is null");
		} else {
			System.out.println("session ID:" + session.getId());
		}
		*/
		return Action.SUCCESS;
	}
}
