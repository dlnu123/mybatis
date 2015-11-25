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
			// mybatis��ȫ�������ļ�
			String resource = "SqlMapConfig.xml";

			// ��ȡ�����ļ���������
			InputStream input = Resources.getResourceAsStream(resource);

			// �����Ự����
			sessionFactory = new SqlSessionFactoryBuilder().build(input);
		}

		return sessionFactory;
	}
}
