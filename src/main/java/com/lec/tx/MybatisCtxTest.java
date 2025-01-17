package com.lec.tx;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MybatisCtxTest {

	public static void main(String[] args) {
		
		//JAVA 기반 설정
//		DataSource dataSource = org.mybatis.spring.SqlSessionFactoryBean.getDataSource();
//		
//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		Environment environment = new Environment("development", transactionFactory, dataSource);
//		
//		Configuration configuration = new Configuration(environment);
//		configuration.addMapper(BlogMapper.class);
		
		//XML 기반 설정 (mybatis-config.xml -- 매퍼:test-mapper.xml)
//		try {
//			String resource = "mybatis-config.xml";
//			Reader reader = Resources.getResourceAsReader(resource);
//			
//			// -------------- builder call test -------------
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//			SqlSession session = sqlSessionFactory.openSession();
//			try {
//				MyBoardVO bvo = (MyBoardVO) session.selectOne("myFirstTest.selectBoard", 5);
//				System.out.println(bvo.getTitle());
//				
//				List<MyBoardVO> list = session.selectList("myFirstTest.selectList");
//				System.out.println(list.size());
//				System.out.println(list.get(0).getRegdate());
//			} finally {
//				session.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//절대경로 : mvc-resource 전용
		String configLocation = "C:\\IT\\STS_SPRING\\SPRING_WORKSPACE\\prj_spring\\src\\main\\webapp\\WEB-INF\\servlet-context-tx.xml";
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(configLocation);
////		String configLocation = "servlet-context-tx.xml";
////		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
//		
		BasicDataSource ds = (BasicDataSource)ctx.getBean("MY_tomcat_ds");
		Connection conn = null;
		try {
		conn = ds.getConnection();
			if(conn != null) {
				System.out.println("dbcp conn ok");
			} else {
				System.out.println("dbcp conn failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// -------------- builder call test -------------
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			MyBoardVO bvo = (MyBoardVO) session.selectOne("myFirstTest.select", 3);
//			System.out.println(bvo.getTitle());
//		} finally {
//			session.close();
//		}

		
	}
}
