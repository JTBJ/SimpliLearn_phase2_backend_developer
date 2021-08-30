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

import com.component.mapping.Eproduct;
import com.component.mapping.ProductParts;
import com.component.mapping.util.HibernateUtil;

/**
 * Servlet implementation class ComponentMapping_ProductDetailsServlet
 */
public class ComponentMapping_ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComponentMapping_ProductDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		List<Eproduct> list = session.createQuery("from Eproduct").list();

		out.println("<html><body>");

		out.println("<b>Component Mapping</b><br><a href='index.html'>Home</a><br/>");
		for (Eproduct p : list) {
			out.println("ID: " + String.valueOf(p.getId()) + ", Name: " + p.getName() + ", Price: "
					+ String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString());
			ProductParts parts = p.getParts();
			
			out.println("Parts =" + parts.getCpu() + ", " + parts.getHdd() + ", " + parts.getRam());
			out.println("<hr>");
		}

		session.close();

		out.println("</body></html>");

	}

}
