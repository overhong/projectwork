package utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//MyBatisManager.setSqlSession()....
public class MyBatisManager {
	private static SqlSessionFactory sqlMapper;
	static {
		String resource = "mybatis/Configuration.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("Mybatis Manager success");
		} catch (IOException e) {
			System.out.println("Mybatis Manager error : " + e.getMessage());
		}
	}

	public static SqlSessionFactory getSqlSession() {
		//private static SqlSessionFactory sqlMapper; 가 private이기 때문에 만든 메소드.
		System.out.println("SqlSession return");
		return sqlMapper;
	}
}
