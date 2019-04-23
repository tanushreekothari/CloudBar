package presentationLayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.ContactLogic;
import businessLayer.UserQuery;


/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private final String password = "pass";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		
		UserQuery uObj = new UserQuery();
		
		uObj.setName(request.getParameter("name"));
		uObj.setEmail(request.getParameter("email"));
		uObj.setContact(request.getParameter("contact"));
        uObj.setWebsiteUrl(request.getParameter("website"));
		uObj.setMessage(request.getParameter("message1"));
		String userName = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")) userName = cookie.getValue();
		}
		ContactLogic cl = new ContactLogic();
		if(cl.insertUserQuery(uObj)) {
			Cookie statusCookie = new Cookie("status","success");
			response.addCookie(statusCookie);
		}
		else {
			Cookie statusCookie = new Cookie("status","failure");
			response.addCookie(statusCookie);
		}
		
		Cookie loginCookie = new Cookie("user",userName);
			//setting cookie to expiry in 30 mins
		loginCookie.setMaxAge(30*60);
		response.addCookie(loginCookie);
		response.sendRedirect("contact.jsp");
	}
}
