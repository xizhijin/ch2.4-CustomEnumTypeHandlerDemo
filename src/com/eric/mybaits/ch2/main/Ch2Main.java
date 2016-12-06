package com.eric.mybaits.ch2.main;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.eric.mybatis.ch2.mapper.UserMapper;
import com.eric.mybatis.ch2.po.Sex;
import com.eric.mybatis.ch2.po.User;
import com.eric.mybatis.ch2.util.SqlSessionFactoryUtil;

public class Ch2Main {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setUserName("eric");
			user.setMobile("18817581390");
			user.setSex(Sex.MALE);
			user.setEmail("eric.xi@hpe.com");
			user.setNote("This is a SexEnumTypeHandler!");
			user.setBirthday(new Date());
			userMapper.insertUser(user);
			
			User user2 = userMapper.getUser(22L);
			System.out.println("The sex of user " + user2.getUsername() + " is " + user2.getSex());
			
			sqlSession.commit();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
