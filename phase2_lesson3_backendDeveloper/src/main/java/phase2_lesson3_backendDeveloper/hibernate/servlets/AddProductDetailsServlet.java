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
import org.hibernate.cfg.Configuration;

import phase2_lesson3_backendDeveloper.practice.Items;
import phase2_lesson3_backendDeveloper.practice.Student;

/**
 * Servlet implementation class AddProductDetailsServlet
 */
public class AddProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String pName = request.getParameter("pName");
		double pPrice = 0;

		try {
			pPrice = Double.parseDouble(request.getParameter("pPrice"));
		} catch (Exception e) {
			out.print("<h4>The value entered for product price must be a number.</h4>");
			out.print("<h6>You will now be redirected to the Add Product page.</h6>");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			response.sendRedirect("addProduct.jsp");
		}

		Items item = new Items(pName, pPrice);

		SessionFactory factory = new Configuration().configure("bigmap.cfg.xml").addAnnotatedClass(Items.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		session.save(item);

		// retrieve the list of students
		List<Items> items = session.createQuery("from Items").list();

		// display student list
		out.print("<a href='index.html'>Home</a>");
		for (Items i : items) {
			out.print("<h3>" + i + "</h3>");
		}

		session.getTransaction().commit();

		session.close();
	}

}
