package Phase2_Lesson2_backendDeveloper.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Phase2_Lesson2_backendDeveloper.dao.DBConnection;

/**
 * Servlet implementation class ProcedureServlet
 */
public class ProcedureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcedureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			InputStream in = getServletContext().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(in);
			Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
			
			CallableStatement stmt = conn.prepareCall("{call add_product(?,?)}");
			stmt.setString(1, "Dodge Charger");
			stmt.setBigDecimal(2, new BigDecimal(6000.50));
			stmt.executeUpdate();
			System.out.println("Procedure Stored");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		out.print("<a href='index.html'>Home</a>");
		out.print("<br/><a href='listProcedure.jsp'>List contents after calling the store procedure</a>");
	}
}
