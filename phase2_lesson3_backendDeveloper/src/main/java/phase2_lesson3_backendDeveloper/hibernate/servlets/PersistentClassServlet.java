package phase2_lesson3_backendDeveloper.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import phase2_lesson3_backendDeveloper.practice.Classes;

/**
 * Servlet implementation class PersistentClassServlet
 */
public class PersistentClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersistentClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//load session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Classes.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.openSession();
		
		//begin transaction
		Transaction tx = session.beginTransaction();
		
		//create persistent object
		Classes subject = 
				new Classes("Mathematics");
		Classes subject2 = 
				new Classes("Full Stack");
		Classes subject3 = 
				new Classes("Network Administration");
		Classes subject4 = 
				new Classes("Science");
		Classes subject5 = 
				new Classes("English");
		
		//save object
		session.save(subject);
		session.save(subject2);
		session.save(subject3);
		session.save(subject4);
		session.save(subject5);
		
		out.print("<a href='index.html'>Home</a>");
		out.print("<h2>Class successfully added</h2>");
		
		//retrieve the data from the classes table
		List<Classes> list = session.createQuery("from Classes", Classes.class).getResultList();
		
		//list data
		for(Classes lists : list) {
			out.print("<h4>" + lists + "</h4>");
		}
		
		//commit transaction
		tx.commit();
	
		//close session
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
