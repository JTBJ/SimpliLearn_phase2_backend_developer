package Phase2_Lesson2_backendDeveloper.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection getConnection(String url, String username, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}

	public static void createManipulationStatement(Connection conn, String query) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
	}
	
	public static ResultSet createQuery(Connection conn, String query) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(query);
	}
}
