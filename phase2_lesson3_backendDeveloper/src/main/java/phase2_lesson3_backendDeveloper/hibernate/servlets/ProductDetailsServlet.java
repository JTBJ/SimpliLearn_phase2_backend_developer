package phase2_lesson3_backendDeveloper.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import phase2_lesson3_backendDeveloper.hibernate.HibernateUtil;
import phase2_lesson3_backendDeveloper.practice.Color;
import phase2_lesson3_backendDeveloper.practice.Eproduct;
import phase2_lesson3_backendDeveloper.practice.Finance;
import phase2_lesson3_backendDeveloper.practice.OS;
import phase2_lesson3_backendDeveloper.practice.ScreenSize;

/**
 * Servlet implementation class ProductDetailsServlet
 */
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		
		List<Eproduct> list = session.createQuery("from Eproduct").list();
		
		out.println("<html><body>");
		out.print("<h2>Product Listing</h2>");
		out.print("<a href='index.html'>Home</a><br/>");
		
		for(Eproduct p : list) {
			out.print("ID: " + String.valueOf(p.getId()) + ", Name: " + p.getName() +
					", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString());
			
			List<Color> colors = p.getColors();
			out.print("<b>Colors</b>");
			for(Color c : colors) {
				out.print(c.getName() + "&nbsp;");
			}
			
			Collection<ScreenSize> sizes = p.getScreenSizes();
			out.print("<b>, Screen Sizes</b>");
			for(ScreenSize s : sizes) {
				out.print(s.getSize() + "&nbsp;");
			}
			
			Set<OS> os = p.getOs();
			out.print("<b>, OS </b>");
			for(OS o : os) {
				out.print(o.getName() + "&nbsp;");
			}
			
			Map<?, ?> finances = p.getFinance();
			out.print("<b>, Finance Options</b>");
			if(finances.get("CreditCard") != null) {
				Finance f = (Finance)finances.get("CreditCard");
				out.print(f.getName() + "&nbsp;");
			}
			
			if(finances.get("Bank") != null) {
				Finance f = (Finance)finances.get("Bank");
				out.print(f.getName() + "&nbsp;");
			}
			
			out.print("<hr>");
		}
		
		session.close();
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
