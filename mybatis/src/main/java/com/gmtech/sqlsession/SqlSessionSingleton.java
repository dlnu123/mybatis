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

		// mybatis��ȫ�������ļ�
		String resource = "SqlMapConfig.xml";

		// ��ȡ�����ļ���������
		InputStream input = Resources.getResourceAsStream(resource);

		// �����Ự����
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);

		// ��ȡsession�Ự
		SqlSession session = sessionFactory.openSession();

		return session;
	}
}
