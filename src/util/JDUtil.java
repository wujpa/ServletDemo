package util;


import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;

public class JDUtil {
	private static Properties properties = new Properties();
	private static LinkedList<Connection> list = new LinkedList<>();
	static String url = null;
	static String usr = null;
	static String psd = null;
	static String diver = null;

	static {
		try {
			InputStream inputStream = ClassLoader.getSystemResourceAsStream("oracle.properties");
			properties.load(inputStream);
			usr = properties.getProperty("user");
			url = properties.getProperty("url");
			psd = properties.getProperty("password");
			diver = properties.getProperty("driverClass");
			Class.forName(diver);


			for (int i = 0; i < 10; i++){
				Connection connection = DriverManager.getConnection(url,usr,psd);
				list.add(connection);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		System.out.println(list.size());
		System.out.println(list);
		return list.size() > 0 ? list.removeFirst():null;
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(String sql ,Object[] o){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < o.length; i++) {
				preparedStatement.setObject(i + 1, o[i]);
			}
			//执行SQL语句
			int d = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection,preparedStatement,null);
		}
	}

	public static ResultSet query(String sql,Object[] objects){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for(int i = 0; i < objects.length; i++){
				preparedStatement.setObject(i+1,  objects[i]);
			}
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally {
			close(connection,preparedStatement,resultSet);
		}
	}
}
