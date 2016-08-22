package com.easyar.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easyar.dao.UserDao;
import com.easyar.entity.User;



public class testcae {
	@Test
	public void test1() throws IOException{
		String str  = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("ar02.jpg")));
		System.out.println(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("ar02.jpg"))));
		
		Path ball_path = Paths.get("C:/Users/YUAN/Pictures", "002.jpg");
		
		
		Files.write(ball_path, Base64.getDecoder().decode(str));
		
		
		
	}
	
	@Test
	public void test2(){
		System.out.println(System.getProperty("user.dir"));
	}
	
	@Test
	public void test3() throws IOException{
		System.out.println(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("ar04.jpg"))));
		
	}
	
	@Test
	public void test4() throws IOException, SQLException{
		String[] conf = {"spring/spring-mvc.xml", "spring/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);

		DataSource ds = ac.getBean("dbcp",DataSource.class);
		Connection con = ds.getConnection();
		
		System.out.println(con+"ok");
		
		con.close();
		System.out.println("connected");
		
		
		SqlSessionFactory factory =  ac.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(factory.openSession());
		
		UserDao userDao = ac.getBean( "userDao",UserDao.class);
		User user = userDao.findUserByEmail("1305882275@qq.com");
		System.out.println(user.toString());
		
	}
	
	@Test
	public void test5(){
		String userid = "9f068813-2c1b-48db-b72a-b3a1bd91b9bf";
		
		System.out.println(userid.matches("[a-z0-9_-]{36}"));
	}
	
	
	
}
