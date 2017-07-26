package cn.homer.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.homer.mybatis.po.Actor;

/**
 * 
 * @author Homer
 *
 */

public class MybatisFirst {
	
	@Test
	public void findActorByIdTest() throws IOException{
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过Sql|Session操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		
		Actor actor = sqlSession.selectOne("test.findActorById", 60);
		
		System.out.println(actor);
		
		//释放资源
		sqlSession.close();
	
	}
	
	@Test
	public void findActorByNameTest() throws IOException{
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过Sql|Session操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		
		List<Actor> actors = sqlSession.selectList("test.findActorByName", "H");
		
		System.out.println(actors);
		
		//释放资源
		sqlSession.close();
	
		
	}
	
	@Test
	public void inserActorTest() throws IOException{
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过Sql|Session操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		
		Actor actor = new Actor();
		actor.setFirst_name("GU");
		actor.setLast_name("HAIMIAO");
		actor.setLast_update(new Date());
		
		
		sqlSession.insert("test.insertActor", actor);
				
		sqlSession.commit();

		System.out.println(actor.getActor_id());
		
		//释放资源
		sqlSession.close();
	
		
	}
	
	
	@Test
	public void deleteActorByIdTest() throws IOException{
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过Sql|Session操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		
		sqlSession.delete("test.deleteActorById", 212);
				
		sqlSession.commit();
		
		//释放资源
		sqlSession.close();
	
		
	}
	
	
	@Test
	public void updateActorByIdest() throws IOException{
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过Sql|Session操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		
		Actor actor = new Actor();
		actor.setActor_id(213);
		actor.setFirst_name("GUA");
		actor.setLast_name("HAIMIAOA");
		actor.setLast_update(new Date());
		
		
		sqlSession.update("test.updateActorById", actor);
				
		sqlSession.commit();
		
		//释放资源
		sqlSession.close();
	
		
	}

}
