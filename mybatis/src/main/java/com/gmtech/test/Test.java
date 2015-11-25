package com.gmtech.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gmtech.po.User;
import com.gmtech.sqlsession.MybatisSessionFactory;

public class Test {
	public static void main(String[] args) throws Exception {
		selectUserById();
		selectUserByName();
		insertUser();
	}

	private static SqlSession getSession() throws Exception {
		SqlSessionFactory sessionFactory = MybatisSessionFactory.getInstance();
		return sessionFactory.openSession();
	}

	private static void selectUserById() throws Exception {
		SqlSession session = getSession();
		User user = session.selectOne("test.selectUserById", 1);
		System.out.println(user);
		session.close();
	}

	private static void selectUserByName() throws Exception {
		SqlSession session = getSession();
		List<User> list = session.selectList("test.selectUserByName", "��");
		System.out.println(list);
		session.close();
	}
	
	private static void insertUser() throws Exception {
		SqlSession session = getSession();
		User user = new User();
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("������������");
		session.insert("test.insertUser", user);
		session.commit();
		session.close();
	}
}
