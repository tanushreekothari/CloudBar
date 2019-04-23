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
import businessLayer.User;
import businessLayer.UserProfileLogic;
/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private final String password = "pass";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		// get request parameters for userID and password
		
		String emailId = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("emailId")) emailId = cookie.getValue();
		}
		}
		User user = new User();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setPassword(request.getParameter("pass"));
		user.setContact(request.getParameter("contact"));
		user.setEmailId(emailId);
		UserProfileLogic upperInfo = new UserProfileLogic();
		
		if(upperInfo.updateUserDetails(user)){
			Cookie loginCookie = new Cookie("user",user.getFirstName());
			Cookie loginCookie1 = new Cookie("emailId",emailId);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.addCookie(loginCookie1);
			
		}
		response.sendRedirect("profile.jsp");

	}
}