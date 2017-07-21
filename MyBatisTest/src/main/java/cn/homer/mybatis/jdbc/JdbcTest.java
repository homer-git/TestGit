package cn.homer.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * @author haimiaogu
 *
 */

public class JdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			//
			Class.forName("com.mysql.jdbc.Driver");
			//
			connection = DriverManager.getConnection("jdbc:mysql://guhm.vicp.cc:3306/sakila?characterEncoding=utf-8","root","123456");
			String sql = "SELECT * FROM sakila.customer where last_name = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, "JONES");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("customer_id") + "  " + resultSet.getString("last_name"));
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(resultSet!=null){
				try{
					resultSet.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try{
					preparedStatement.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			if(connection!=null){
				try{
					connection.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}

	}

}
