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

import businessLayer.LoginAuthentication;
/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private final String password = "pass";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		// get request parameters for userID and password
		String user = request.getParameter("username");
		String pwd = request.getParameter("pass");
		System.out.println("username:"+user);
		LoginAuthentication la = new LoginAuthentication();
		HashMap<String, String> map = la.fetchPasswordAndName(user);
		if(null==map || null== map.get("pass") || map.get("pass").isEmpty() ) {
			flag = false;
		}
		String page ="success.jsp";
		if(flag == true && map.get("pass").equals(pwd)){
			Cookie loginCookie = new Cookie("user",map.get("name"));
			Cookie loginCookie1 = new Cookie("emailId",user);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.addCookie(loginCookie1);
			if(user.equalsIgnoreCase("admin")) {
				page ="admin.jsp";
			}
			response.sendRedirect(page);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			request.setAttribute("alertMsg", "Either user name or password is incorrect");
			rd.include(request, response);
		}

	}
}
