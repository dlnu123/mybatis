package com.gmtech.dao;

import com.gmtech.po.User;

public interface UserDao {
	User selectUserById(int id) throws Exception;

	void insertUser(User user) throws Exception;

	void deleteUser(int id) throws Exception;
}