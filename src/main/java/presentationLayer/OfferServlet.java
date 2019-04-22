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
		
		String product = request.getParameter("product");
		String city = request.getParameter("city");
		String userName = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")) userName = cookie.getValue();
		}
		Cookie loginCookie = new Cookie("user",userName);
			//setting cookie to expiry in 30 mins
		loginCookie.setMaxAge(30*60);
		response.addCookie(loginCookie);
		if(null!=city) {
			Cookie cityCookie = new Cookie("city",city.replaceAll(" ", ""));
			response.addCookie(cityCookie);
		}
		if(null!=product) {
			Cookie prodCookie = new Cookie("product",product);
			response.addCookie(prodCookie);
		}
		response.sendRedirect("products.jsp");
	}
}