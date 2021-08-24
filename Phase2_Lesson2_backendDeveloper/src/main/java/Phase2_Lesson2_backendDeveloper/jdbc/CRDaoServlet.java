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
public class CRDaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRDaoServlet() {
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
				out.print("<td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>"
						+ rs.getString(3) + "</td><td>" + rs.getString(4) + "</td>");
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
}
