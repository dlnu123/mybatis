package com.gmtech.sqlsession;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionSingleton {
	private SqlSessionSingleton() {

	}

	public static SqlSession getInstance() throws Exception {

		// mybatis的全局配置文件
		String resource = "SqlMapConfig.xml";

		// 获取配置文件的输入流
		InputStream input = Resources.getResourceAsStream(resource);

		// 创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);

		// 获取session会话
		SqlSession session = sessionFactory.openSession();

		return session;
	}
}
