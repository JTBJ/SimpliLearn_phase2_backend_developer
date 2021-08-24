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
 * Servlet implementation class CRDaoServlet
 */
public class InsertUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertUpdateDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String query = "select * from Student";
		PrintWriter out = response.getWriter();

		try {
			InputStream in = getServletContext().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(in);
			Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));

			ResultSet rs = DBConnection.createQuery(conn, query);

			out.print("<a href='index.html'>Home</a>");
			out.print("<table border='1'>");
			out.print("<tr>");
			out.println("<th>Id</th>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Email</th>");
			out.print("</tr>");

			while (rs.next()) {
				out.println("<tr>");
				out.print("<td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td>");
				out.println("</tr>");
			}

			out.print("</table>");
			in.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("update") != null) {
			if (request.getParameter("update").equals("updateRecord")) {
				update(request, response);
				return;
			}
		}
		
		if(request.getParameter("Id_delete") != null) {
			if (request.getParameter("Id_delete").equals("deleteRecord")) {
				try {
					delete(request, response);
				} catch (ClassNotFoundException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
				
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");

		String query = "INSERT INTO Student (First_Name, Last_Name, Email) VALUES ('" + firstName + "','" + lastName
				+ "','" + email + "')";

		try {
			InputStream in = getServletContext().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(in);
			Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));

			DBConnection.createManipulationStatement(conn, query);
			out.print("<a href='index.html'>Home</a>");
			out.print("<h1>Data added successfully!</h1>");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Connection getNewConnection() throws SQLException, IOException, ClassNotFoundException {
		InputStream in = getServletContext().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		prop.load(in);
		Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
		in.close();
		return conn;
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("Id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();

		try {
			InputStream in = getServletContext().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(in);
			Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));

			if (fname != null) {
				DBConnection.createManipulationStatement(conn, "UPDATE Student SET First_Name = '" + fname 
																+ "' WHERE Id ='" + id + "'");
			}
			if (lname != null) {
				DBConnection.createManipulationStatement(conn, "UPDATE Student SET Last_Name = '" + lname 
																+ "' WHERE Id ='" + id + "'");
			}
			if (email != null) {
				DBConnection.createManipulationStatement(conn, "UPDATE Student SET Email = '" + email + 
																"' WHERE Id ='" + id + "'");
			}

			out.print("<a href='index.html'>Home</a>");
			out.print("<h1>Recored updated successfully</h1>");
			in.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		String id = request.getParameter("Id");
		PrintWriter out = response.getWriter();
		
		InputStream in = getServletContext().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"), 
				prop.getProperty("password"));
		
		DBConnection.createManipulationStatement(conn, "DELETE FROM Student WHERE id = '" + id + "'");
		
		out.print("<a href='index.html'>Home</a>");
		out.print("<h1>Recored deleted successfully</h1>");
	}

}
