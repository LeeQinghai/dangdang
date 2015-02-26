package com.qinghai.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qinghai.model.Users;

public class UserServiceImplTest {

	@Test
	public void testGetUserById() {
		UserServiceImpl us = new UserServiceImpl();
		Users user = us.getUserById(1);
		System.out.println(user.getId());
	}

}
