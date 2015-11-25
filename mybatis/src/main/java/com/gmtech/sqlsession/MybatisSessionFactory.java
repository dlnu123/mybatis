package com.gmtech.sqlsession;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSessionFactory {
	private static SqlSessionFactory sessionFactory = null;

	private MybatisSessionFactory() {

	}

	public static SqlSessionFactory getInstance() throws Exception {
		if (sessionFactory == null) {
			// mybatis的全局配置文件
			String resource = "SqlMapConfig.xml";

			// 获取配置文件的输入流
			InputStream input = Resources.getResourceAsStream(resource);

			// 创建会话工厂
			sessionFactory = new SqlSessionFactoryBuilder().build(input);
		}

		return sessionFactory;
	}
}
