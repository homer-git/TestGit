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
		
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����������mybatis�������ļ�
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ͨ��Sql|Session�������ݿ�
		//��һ��������ӳ���ļ���statement��id������=namespace+statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		
		Actor actor = sqlSession.selectOne("test.findActorById", 60);
		
		System.out.println(actor);
		
		//�ͷ���Դ
		sqlSession.close();
	
	}
	
	@Test
	public void findActorByNameTest() throws IOException{
		
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����������mybatis�������ļ�
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ͨ��Sql|Session�������ݿ�
		//��һ��������ӳ���ļ���statement��id������=namespace+statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		
		List<Actor> actors = sqlSession.selectList("test.findActorByName", "H");
		
		System.out.println(actors);
		
		//�ͷ���Դ
		sqlSession.close();
	
		
	}
	
	@Test
	public void inserActorTest() throws IOException{
		
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����������mybatis�������ļ�
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ͨ��Sql|Session�������ݿ�
		//��һ��������ӳ���ļ���statement��id������=namespace+statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		
		Actor actor = new Actor();
		actor.setFirst_name("GU");
		actor.setLast_name("HAIMIAO");
		actor.setLast_update(new Date());
		
		
		sqlSession.insert("test.insertActor", actor);
				
		sqlSession.commit();

		System.out.println(actor.getActor_id());
		
		//�ͷ���Դ
		sqlSession.close();
	
		
	}
	
	
	@Test
	public void deleteActorByIdTest() throws IOException{
		
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����������mybatis�������ļ�
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ͨ��Sql|Session�������ݿ�
		//��һ��������ӳ���ļ���statement��id������=namespace+statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		
		sqlSession.delete("test.deleteActorById", 212);
				
		sqlSession.commit();
		
		//�ͷ���Դ
		sqlSession.close();
	
		
	}
	
	
	@Test
	public void updateActorByIdest() throws IOException{
		
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����������mybatis�������ļ�
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ͨ��Sql|Session�������ݿ�
		//��һ��������ӳ���ļ���statement��id������=namespace+statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		
		Actor actor = new Actor();
		actor.setActor_id(213);
		actor.setFirst_name("GUA");
		actor.setLast_name("HAIMIAOA");
		actor.setLast_update(new Date());
		
		
		sqlSession.update("test.updateActorById", actor);
				
		sqlSession.commit();
		
		//�ͷ���Դ
		sqlSession.close();
	
		
	}

}
