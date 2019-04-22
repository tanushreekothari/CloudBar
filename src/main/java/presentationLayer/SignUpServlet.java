package presentationLayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.User;
import businessLayer.UserProfileLogic;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User userProfile = new User();
		userProfile.setPassword(request.getParameter("pass"));
		userProfile.setEmailId(request.getParameter("email"));
		userProfile.setContact(request.getParameter("contact"));
		userProfile.setFirstName(request.getParameter("firstname"));
		userProfile.setLastName(request.getParameter("lastname"));
		UserProfileLogic profile = new UserProfileLogic();
		if(profile.createUserProfile(userProfile)){
			Cookie loginCookie = new Cookie("user",userProfile.getFirstName());
			Cookie loginCookie1 = new Cookie("username",userProfile.getEmailId());
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.addCookie(loginCookie1);
			response.sendRedirect("successignup.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/signup.jsp");
			request.setAttribute("alertMsg", "Cheers! You are already part of the Cloud Bar community. Please LogIn to continue!");
			rd.include(request, response);
		}

	}
}
