package cn.homer.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

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
		Actor actor = sqlSession.selectOne("test.findUserById", 60);
		
		System.out.println(actor);
		
		//�ͷ���Դ
		sqlSession.close();
	
	}
	

}
