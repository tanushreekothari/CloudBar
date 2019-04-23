package presentationLayer;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.OrderLogic;
import businessLayer.User;
import businessLayer.UserProfileLogic;
/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private final String password = "pass";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		// get request parameters for userID and password
		try {
		String emailId = null;
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("user")) userName = cookie.getValue();
			if(cookie.getName().equals("emailId")) emailId = cookie.getValue();
		}
		}
		Order order = new Order();
		order.setLiquorName(request.getParameter("liquor"));
		order.setCost(request.getParameter("cost"));
		order.setBarName(request.getParameter("bar"));
		order.setEmailId(emailId);
		OrderLogic orderInfo = new OrderLogic();
		orderInfo.insertOrderDetails(order);
			Cookie loginCookie = new Cookie("user",userName);
			Cookie loginCookie1 = new Cookie("emailId",emailId);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.addCookie(loginCookie1);
			response.sendRedirect("Order.jsp");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}