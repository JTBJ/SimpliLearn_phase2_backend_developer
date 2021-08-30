package phase2_lesson3_backendDeveloper.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import phase2_lesson3_backendDeveloper.hibernate.HibernateUtil;

/**
 * Servlet implementation class InitHibernateServlet
 */
public class InitHibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitHibernateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			out.println("<html><body><a href='index.html'>Home</a>");
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			out.println("<h2>Hibernate Session opened.</h2><br>");
			System.out.println("Hibernate Session opened.");
            session.close();
            System.out.println("Hibernate Session closed.");
			out.println("<h2>Hibernate Session closed.</h2><br>");      
            out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
