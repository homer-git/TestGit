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
		Actor actor = sqlSession.selectOne("test.findUserById", 60);
		
		System.out.println(actor);
		
		//释放资源
		sqlSession.close();
	
	}
	

}
