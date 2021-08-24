package Phase2_Lesson2_backendDeveloper.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavaClassDAO {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/NewDatabase?useSSL=false";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		Connection conn = DBConnection.getConnection(jdbcUrl, userName, password);
		
		DBConnection.createManipulationStatement(conn, "CREATE DATABASE IF NOT EXISTS NewDatabase");
		System.out.println("connection succeded\n");
		
		//DBConnection.createManipulationStatement(conn, "DROP TABLE Student");
		DBConnection.createManipulationStatement(conn, "CREATE TABLE IF NOT EXISTS Student" +
						"(id INT not NULL AUTO_INCREMENT, " +
						"First_Name VARCHAR(255), "+
						"Last_Name VARCHAR(255), "+
						"Email VARCHAR(255), "+
						"PRIMARY KEY(id))");
		//DBConnection.createManipulationStatement(conn, "INSERT INTO Student (First_Name, Last_Name, Email) VALUES ('John', 'Hatmos', 'jjon@hatmos.com')");
		
		ResultSet rs = DBConnection.createQuery(conn, "select * from Student");
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}
	}

}
