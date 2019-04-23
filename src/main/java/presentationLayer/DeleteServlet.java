package presentationLayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private final String password = "pass";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		// get request parameters for userID and password
		String emailIdVal = request.getParameter("emailVal");
		String barId = request.getParameter("barVal");
		String productId = request.getParameter("prodVal");
		String emailId = null;
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("emailId")) emailId = cookie.getValue();
			if(cookie.getName().equals("user")) userName = cookie.getValue();
		}
		}
		if(null!=emailIdVal) {
			UserInfo user= new UserInfo();
			user.deleteUser(emailIdVal);
		}
		else if(null!=productId) {
			ProductInfo prod = new ProductInfo();
			prod.deleteProduct(productId);
		}
		else {
			BarInfo bar = new BarInfo();
			bar.deleteBarAgent(Integer.parseInt(barId));
		}
	
			Cookie loginCookie = new Cookie("user",userName);
			Cookie loginCookie1 = new Cookie("emailId",emailId);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.addCookie(loginCookie1);
			response.sendRedirect("admin.jsp");

	}
}