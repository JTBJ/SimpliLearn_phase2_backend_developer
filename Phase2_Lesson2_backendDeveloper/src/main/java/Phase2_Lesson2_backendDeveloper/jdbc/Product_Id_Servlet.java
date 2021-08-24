package Phase2_Lesson2_backendDeveloper.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Phase2_Lesson2_backendDeveloper.dao.DBConnection;

/**
 * Servlet implementation class Product_Id_Servlet
 */
public class Product_Id_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Product_Id_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("list") != null) {
			listContents(request, response);
			return;
		}
		
		if(request.getParameter("Id") != null) {
			try {
				selectById(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		InputStream in = getServletContext().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		prop.load(in);

		PrintWriter out = response.getWriter();

		String deleteDatabaseQuery = "DROP DATABASE eCommerce";
		String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS eCommerce";
		String selectDatabase = "USE eCommerce";
		String createTableQuery = "CREATE TABLE IF NOT EXISTS items (" + "product_id BIGINT PRIMARY KEY AUTO_INCREMENT,"
				+ "pName VARCHAR(255)," + "pPrice DECIMAL(10, 2)," + "date_added TIMESTAMP DEFAULT NOW());";
		String insertQuery1 = "INSERT INTO items (pName, pPrice) values ('Mischellaneous', '1000.00')";
		String insertQuery2 = "INSERT INTO items (pName, pPrice) values ('School Books', '1000.00')";
		String insertQuery3 = "INSERT INTO items (pName, pPrice) values ('Tuition', '11000.00')";
		String insertQuery4 = "INSERT INTO items (pName, pPrice) values ('Dell Laptop', '600.00')";
		String insertQuery5 = "INSERT INTO items (pName, pPrice) values ('Monitor', '100.00')";
		String insertQuery6 = "INSERT INTO items (pName, pPrice) values ('Habbitat', '1300.00')";
		String insertQuery7 = "INSERT INTO items (pName, pPrice) values ('Vehicle', '6000.00')";
		String insertQuery8 = "INSERT INTO items (pName, pPrice) values ('Clothing', '2000.00')";
		String insertQuery9 = "INSERT INTO items (pName, pPrice) values ('Food', '3000.00')";
		String insertQuery10 = "INSERT INTO items (pName, pPrice) values ('Gas', '1500.00')";
		String insertQuery11 = "INSERT INTO items (pName, pPrice) values ('Phone', '600.00')";

		try {
			Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));

			DBConnection.createManipulationStatement(conn, deleteDatabaseQuery);
			out.println("<h2>Database deleted</h2>");
			DBConnection.createManipulationStatement(conn, createDatabaseQuery);
			out.println("<h2>Database created</h2>");
			DBConnection.createManipulationStatement(conn, selectDatabase);
			out.println("<h2>Database selected</h2>");
			DBConnection.createManipulationStatement(conn, createTableQuery);
			out.println("<h2>Table created</h2>");
			DBConnection.createManipulationStatement(conn, insertQuery1);
			DBConnection.createManipulationStatement(conn, insertQuery2);
			DBConnection.createManipulationStatement(conn, insertQuery3);
			DBConnection.createManipulationStatement(conn, insertQuery4);
			DBConnection.createManipulationStatement(conn, insertQuery5);
			DBConnection.createManipulationStatement(conn, insertQuery6);
			DBConnection.createManipulationStatement(conn, insertQuery7);
			DBConnection.createManipulationStatement(conn, insertQuery8);
			DBConnection.createManipulationStatement(conn, insertQuery9);
			DBConnection.createManipulationStatement(conn, insertQuery10);
			DBConnection.createManipulationStatement(conn, insertQuery11);
			out.println("<h2>Table populated</h2>");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void listContents(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String query2 = "SELECT * FROM eCommerce.items";

		try {
			InputStream in = getServletContext().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(in);
						
			Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
			
			ResultSet rs = DBConnection.createQuery(conn, query2);

			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<th>Product ID</th>");
			out.print("<th>Product Name</th>");
			out.print("<th></td>Product Price</th>");
			out.print("<th>Date Added</th>");
			out.print("</tr>");

			while (rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td>");
				out.print("</tr>");
			}

			out.print("</table>");
			in.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {

		InputStream in = getServletContext().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		prop.load(in);
		Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
		
		String id = request.getParameter("Id");
		String query = "SELECT * FROM eCommerce.items WHERE product_id='" + id + "'";
		
		ResultSet rs = DBConnection.createQuery(conn, query);
		
		PrintWriter out = response.getWriter();
		
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>Product ID</th>");
		out.print("<th>Product Name</th>");
		out.print("<th></td>Product Price</th>");
		out.print("<th>Date Added</th>");
		out.print("</tr>");
		while(rs.next()) {
			out.print("<tr>");
			out.print("<td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
					+ "</td><td>" + rs.getString(4) + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}
}
