package com.gmtech.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gmtech.dao.UserDao;
import com.gmtech.po.User;
import com.gmtech.sqlsession.MybatisSessionFactory;

public class UserDaoImpl implements UserDao {

	private SqlSession getSession() throws Exception {
		SqlSessionFactory sessionFactory = MybatisSessionFactory.getInstance();
		return sessionFactory.openSession();
	}

	public User selectUserById(int id) throws Exception {
		SqlSession session = getSession();
		User user = session.selectOne("test.selectUserById", 1);
		session.close();
		return user;
	}

	public void insertUser(User user) throws Exception {
		SqlSession session = getSession();
		session.insert("test.insertUser", user);
		session.commit();
		session.close();
	}

	public void deleteUser(int id) throws Exception {
		SqlSession session = getSession();
		session.delete("test.deleteUser", id);
		session.commit();
		session.close();
	}
}