package com.gmtech.test;

import org.apache.ibatis.session.SqlSession;

import com.gmtech.po.User;
import com.gmtech.sqlsession.SqlSessionSingleton;

public class Test {
	public static void main(String[] args) throws Exception {
		selectUserById();
	}

	private static void selectUserById() throws Exception {
		SqlSession session = SqlSessionSingleton.getInstance();
		User user = session.selectOne("test.selectUserById", 1);
		System.out.println(user);
		session.close();
	}
}
