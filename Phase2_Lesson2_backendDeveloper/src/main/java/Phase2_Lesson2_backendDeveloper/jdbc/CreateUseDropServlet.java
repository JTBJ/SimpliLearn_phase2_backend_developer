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
 * Servlet implementation class CreateUseDropServlet
 */
public class CreateUseDropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUseDropServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameter1 = request.getParameter("create");
		String parameter2 = request.getParameter("use");
		String parameter3 = request.getParameter("delete");
		String parameter4 = request.getParameter("task");
		
		PrintWriter out = response.getWriter();
		
		InputStream in = getServletContext().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		try {
			Connection conn = DBConnection.getConnection(prop.getProperty("url1"), prop.getProperty("username"), prop.getProperty("password"));
			if(parameter1 != null) {
				String query = "CREATE DATABASE ";
				if(parameter1.contains(" ")) {
					parameter1 = parameter1.replace(" ", "_");
				}
				DBConnection.createManipulationStatement(conn, query + parameter1);
				out.println("<h1>" + parameter1 + " database created </h1>");
				out.print("<a href='index.html'>Home</a>");
			}else if(parameter2 != null) {
				String query = "USE ";
				DBConnection.createManipulationStatement(conn, query + parameter2);
				out.println("<h1>" + parameter2 + " database in use </h1>");
				out.print("<a href='index.html'>Home</a>");
			}else if(parameter3 != null) {
				String query = "DROP DATABASE ";
				if(parameter3.contains(" ")) {
					parameter3 = parameter3.replace(" ", "_");
				}
				DBConnection.createManipulationStatement(conn, query + parameter3);
				out.println("<h1>" + parameter3 + " database deleted </h1>");
				out.print("<a href='index.html'>Home</a>");
			}else if(parameter4 != null) {
				String query = "SHOW DATABASES;";
				out.print("<h1>Here is the list of databases</h1>");
				out.print("<a href='index.html'>Home</a>");
				ResultSet rs = DBConnection.createQuery(conn, query);
				out.print("<table border='1'>");
				while(rs.next()) {
					out.print("<tr><td>");
					out.print(rs.getString("Database"));
					out.print("</td></tr>");
				}
				out.print("</table>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
