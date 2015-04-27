package kr.ac.mju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.ac.mju.dto.LoginInfo;
import kr.ac.mju.dto.User;

public class PlainDAO {
	 
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.getMessage();
		}
	}
	
	private final static String url = "jdbc:mysql://localhost:3306/lms";
	private final static String id = "lge920904";
	private final static String pw = "82150009";
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,id,pw);
	}
	
	private void closeConnection(Connection connection,Statement statement, ResultSet resultSet) throws SQLException{
		if(connection == null) return;
		connection.close();
		statement.close();
		resultSet.close();
	}

	public User login(LoginInfo info) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from user where id=? and password =?";
		User user = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				if(id.equals(info.getID()) && password.equals(info.getPassword())){
					user = new User();
					user.setID(id);
					user.setName(resultSet.getString("name"));
					user.setPassword(password);
					user.setCategory(resultSet.getString("category"));
				}
			}
			closeConnection(connection, statement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	
	
}
