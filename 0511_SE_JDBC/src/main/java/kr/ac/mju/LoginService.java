package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private final static String URL = "jdbc:mysql://localhost:3306/lms";
	private final static String ID = "sogong";
	private final static String PASSWORD = "mju12345";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	private void closeConnection(Connection connection, 
			Statement statement, ResultSet resultSet) throws SQLException {
		if(connection == null) {
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}

	public User login(String userID, String userPassword) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// dao 호출
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from user";
		User user = null;
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			String password = resultSet.getString("password");
			
			if(id.equals(userID) && password.equals(userPassword)) {
				user = new User();
				user.setID(id);
				user.setName(resultSet.getString("name"));
				user.setPassword(password);
				closeConnection(connection, statement, resultSet);
				return user;
			}
		}
			
		closeConnection(connection, statement, resultSet);
		return null;
	}

}
