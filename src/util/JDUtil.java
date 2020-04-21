package util;


import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class JDUtil {
	private static Properties properties = new Properties();
	private static LinkedList<Connection> list = new LinkedList<>();
	static String url = null;
	static String usr = null;
	static String psd = null;
	static String diver = null;

	static {
		try {
			/**
			 * tomcat中使用这个读取不到配置文件，
			 */
//			InputStream inputStream = ClassLoader.getSystemResourceAsStream("/oracle.properties");
			InputStream inputStream = JDUtil.class.getClassLoader().getResourceAsStream("oracle.properties");

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

	public static boolean update(String sql ,Object[] o){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < o.length; i++) {
				preparedStatement.setObject(i + 1, o[i]);
			}
			//执行SQL语句
			int d = preparedStatement.executeUpdate();
			return d > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(connection,preparedStatement,null);
		}
	}

	public static List query(String sql,Object[] objects){
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
			return convertResult(resultSet);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally {
			close(connection,preparedStatement,resultSet);
		}
	}

	public static List convertResult(ResultSet resultSet){
		//获得结果集结构信息,元数据
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSetMetaData md = null;
		try {
			md = resultSet.getMetaData();
			int columnCount = md.getColumnCount();
			while (resultSet.next()){
				Map<String , Object> rowData = new HashMap<>();
				for (int i = 1; i <= columnCount; i++){
					rowData.put(md.getColumnName(i),resultSet.getObject(i));
				}
				list.add(rowData);
			}
			return list;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null;
		}
	}
}
