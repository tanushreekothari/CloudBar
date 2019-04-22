package presentationLayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/OfferServlet")
public class OfferServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private final String password = "pass";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		try {
		// get request parameters for userID and password
		System.out.println("I am here testing search functionality");
		String product = request.getParameter("product");
		String city = request.getParameter("city");
		String userName = request.getParameter("userId");
		
		System.out.println("I am here testing search functionality"+product);
			Cookie prodCookie = new Cookie("product",product);
			Cookie cityCookie = new Cookie("city",city);
			Cookie loginCookie = new Cookie("user",userName);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(prodCookie);
			response.addCookie(cityCookie);
			response.addCookie(loginCookie);
			response.sendRedirect("about.jsp");
		}
		catch(Exception e) {
			System.out.print(e);
		}
		

	}
}