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

import phase2_lesson3_backendDeveloper.hibernate.HibernateUtil;
import phase2_lesson3_backendDeveloper.practice.Student;

/**
 * Servlet implementation class ListContentServlet
 */
public class ListContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListContentServlet() {
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
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//create session
		Session session = factory.openSession();
		
		//begin transaction
		Transaction tx = session.beginTransaction();
		
		//creating persistent object
		Student student1 = new Student("Scooby", "Bacon", "bacon@Scooby.com");
		Student student2 = new Student("Adam", "Chandler", "chandler@adam.com");
		Student student3 = new Student("Thomas", "Baily", "baily@thomas.com");
		Student student4 = new Student("James", "Benton", "benton@james.com");
		Student student5 = new Student("Simpli", "Learn", "learn@simpli.com");
		
		//saving students
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		session.save(student5);
		
		//retrieve the list of students
		List<Student> student = session.createQuery("from Student").list();
		
		//display student list
		out.print("<a href='index.html'>Home</a>");
		for(Student students : student) {
			out.print("<h3>" + students + "</h3>");
		}
		
		//commit transaction
		tx.commit();
		
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
