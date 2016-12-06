package com.eric.mybatis.ch2.mapper;

import com.eric.mybatis.ch2.po.User;

public interface UserMapper {
	
	public User getUser(Long id);
	
	public void insertUser(User user);
}
