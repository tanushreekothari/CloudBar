<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="presentationLayer.UserInfo"%>
<%@ page import="businessLayer.User"%>
<%@ page import="presentationLayer.ProductInfo"%>
<%@ page import="businessLayer.Product"%>
<%@ page import="presentationLayer.BarInfo"%>
<%@ page import="businessLayer.BarAgent"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cloud Bar</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="The Venue template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/jquery-datepicker/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="plugins/jquery-timepicker/jquery.timepicker.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/menu.css">
<link rel="stylesheet" type="text/css" href="styles/menu_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/contactus.css">
<link rel="stylesheet" type="text/css"  href="styles/admin.css">
<style>
.logo img {
    width: 100px;
    height: 50px;
    vertical-align: sub;
    border-style: none;
}

}
</style>
</head>
<body>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("index.jsp");
%>
<div class="super_container">
	
	<!-- Header -->

	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="header_content d-flex flex-row align-items-center justify-content-start">
						<div class="logo">
							<a href="home.jsp">
								<div>Cloud Bar <img src="cloud.png" alt="CloudBarLogo"></div>
								<div></div>
							</a>
						</div>
						<nav class="main_nav">
							<ul class="d-flex flex-row align-items-center justify-content-start">
								
								<li><a href="about.jsp">about</a></li>
								<li><a href="products.jsp">Products</a></li>
								<li><a href="offers.jsp">Offers</a></li>
								<li><a href="blog.jsp">blog</a></li>
								<li><a href="contact.jsp">contact</a></li>
							</ul>
						</nav>
						<div class="reservations_phone ml-auto" style=" border: none;"><a href="">Welcome admin</a></div>
						<form action="LogoutServlet" method="post"><div class="reservations_phone ml-auto"><input type="submit" value="LOGOUT" style="background-color: Transparent;
    background-repeat:no-repeat;
    border: none;
    cursor:pointer;
    overflow: hidden;
    outline:none; color:white;" ></div></form>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Hamburger -->

	<!-- Hamburger -->
	
	<div class="hamburger_bar trans_400 d-flex flex-row align-items-center justify-content-start">
		<div class="hamburger">
			<div class="menu_toggle d-flex flex-row align-items-center justify-content-start">
				<span>menu</span>
				<div class="hamburger_container">
					<div class="menu_hamburger">
						<div class="line_1 hamburger_lines" style="transform: matrix(1, 0, 0, 1, 0, 0);"></div>
						<div class="line_2 hamburger_lines" style="visibility: inherit; opacity: 1;"></div>
						<div class="line_3 hamburger_lines" style="transform: matrix(1, 0, 0, 1, 0, 0);"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Menu -->

	 <div class="menu trans_800">
  		<div class="menu_content d-flex flex-column align-items-center justify-content-center text-center">
  			<ul>
  				
  								<li><a href="home.jsp">Home</a></li>
  								<li><a href="about.jsp">about</a></li>
								<li><a href="products.jsp">Products</a></li>
								<li><a href="offers.jsp">Offers</a></li>
								<li><a href="blog.jsp">blog</a></li>
								<li><a href="contact.jsp">contact</a></li>
  			</ul>
  		</div>
  		<div class="menu_reservations_phone ml-auto"><a style="color:white" href="">Hi <%=userName %></a></div>
  	<form action="LogoutServlet" method="post">	<div class="menu_reservations_phone1 ml-auto"><input type="submit" value="LOGOUT" style="background-color: Transparent;
      background-repeat:no-repeat;
      border: none;
      cursor:pointer;
      overflow: hidden;
      outline:none; color:white;" ></div></form>
  	</div>
	
	<!-- Home -->

	<div class="home">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/imageedit_1_9859033174.jpg" data-speed="0.8"></div>
		<div class="home_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="home_content text-center">
							<div class="home_subtitle page_subtitle">Cloud Bar</div>
							<div class="home_title"><h1>For Admin Access Only</h1></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<div id="user_info">
<!-- User Profile Table Content -->

<div class="table_fetch">
<h2>User Profile Table</h2>

<table>
<%UserInfo obj = new UserInfo();
ArrayList<User> users = obj.getAllUsers();%>
<thead>
    <tr>
      <th scope="col">Email Id</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Contact Number</th>
	  <th scope="col">Registration Date</th>
    </tr>
  </thead>

  <tbody>
  <% for(User user:users){%>
  <tr>
	  <!-- Fetching User Information from User Profile table -->
	  
	    
    <td scope="row" data-label="Email Id"><%=user.getEmailId() %></td>
    <td scope="row" data-label="First Name"><%=user.getFirstName() %></td>
    <td scope="row" data-label="Last Name"><%=user.getLastName() %></td>
    <td scope="row" data-label="Contact Number"><%=user.getContact() %></td>
	<td scope="row" data-label="Registration Date"><%=user.getDate() %></td>
	
	</tr>
	<%} %>
 </tbody>
</table>

</div>

<!-- Deleting a particular user entered by the admin -->

<div class="delete_element_table"> 
<form id="del_userid" action="DeleteServlet" method="post" style="display: block;">
<div class="delete_element_text">
<label for="userid">Enter the email id you want to delete: </label>
<input class="input_text" type="text" name="emailVal" tabindex="1" placeholder="Email Id" value="">
</div>
<div class="delete_element_btn">
<input type="submit" name="register-submit" class="btn-delete" tabindex="5" value="Delete">
</div>
 
 					<!-- For displaying error message if no email id entered -->
						  
					<!-- For displaying success message on deletion -->
						  
						
					<!-- For displaying error message on inappropriate email id -->
						  
						
</form>
</div>

</div> 
<!-- End of user profile content -->

<div id="product_info">
<!-- Product Info Table Content -->

<div class="table_fetch">
<h2>Product Information</h2>

<table>
<thead>
  <tr>
   <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
    
    
    
    
  </tr>
  </thead>
  <tbody>
  <%ProductInfo prodObj = new ProductInfo();
  ArrayList<Product> products = prodObj.getAllProducts();
  for(Product product: products){%>
  <tr>
	  <!-- Fetching Product Information from Product information table -->
	  
	    
    <td scope="row" data-label="Product Id"><%=product.getProductId() %></td>
    <td scope="row" data-label="Product Name"><%=product.getProductName() %></td>

	</tr>
	<%} %>
  </tbody>
</table>

</div>

<!-- Deleting a particular product entered by the admin -->

<div class="delete_element_table">
<form id="del_recipeid" action="DeleteServlet" method="post" style="display: block;">
<div class="delete_element_text">
<label for="recipeid">Enter the product id you want to delete: </label>
<input class="input_text" type="text" name="prodVal"  tabindex="1" placeholder="Product Id" value="">
</div>
<div class="delete_element_btn">
<input type="submit" name="register-submit" class="btn-delete" tabindex="5" value="Delete">
</div>
   
					<!-- For displaying error message if no product id entered -->
						  
					<!-- For displaying success message on deletion -->
						  
					<!-- For displaying error message on inappropriate product id -->
						  

</form>
</div>

</div>
<!-- End of product content -->

<div id="bar_info">
<!-- Review Table Content -->

<div class="table_fetch">
<h2>Bar Agents Information</h2>

<table>

 <thead>
 <%BarInfo barObj = new BarInfo();
  ArrayList<BarAgent> bars = barObj.getAllBarAgents();%>
 
    <tr>
      <th scope="col">Bar Id</th>
      <th scope="col">Bar Name</th>
      <th scope="col">is sponsored</th>
      <th scope="col">Bar Rank</th>
	  <th scope="col">Bar Weight</th>
    </tr>
  </thead>
  
  <tbody>
   <% for(BarAgent bar: bars){%>
  <tr>
	  <!-- Fetching Bar Information from Bar Info table -->
	  
	    
  <td scope="row" data-label="Bar Id"><%=bar.getBarId() %></td>
    <td scope="row" data-label="Bar Name"><%=bar.getBarName() %></td>
    <td scope="row" data-label="is sponsored"><%=bar.getIsSponsored() %></td>
    <td scope="row" data-label="Bar Rank"><%=bar.getBarRank() %></td>
	<td scope="row" data-label="Bar Weight"><%=bar.getBarWeight() %></td>
     
  </tr>
  <%} %>
	 </tbody>
 
</table>

</div>  

<!-- Deleting a particular bar entered by the admin -->

<div class="delete_element_table">
<form id="del_reveiwid" action="DeleteServlet" method="post" style="display: block;">
<div class="delete_element_text">
<label for="reviewid">Enter the bar id you want to delete: </label>
<input class="input_text" type="text" name="barVal" tabindex="1" placeholder="Bar Id" value="">
</div>
<div class="delete_element_btn">
<input type="submit" name="register-submit" class="btn-delete" tabindex="5" value="Delete">
</div>


					<!-- For displaying error message if no bar id entered -->
						  
					<!-- For displaying success message on deletion -->
						  
					<!-- For displaying error message on inappropriate bar id -->
						  
</form>
</div>

</div>

<!-- End of bar content -->
	
	<!-- Footer -->

		<footer class="footer">
		<div class="container">
			<div class="row">

				<!-- Footer Logo -->
				<div class="col-lg-3 footer_col">
					<div class="footer_logo">
						<div class="footer_logo_title">Cloud Bar</div>
						
					</div>
					<div class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
<p style="line-height: 1.2;">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This website is made by Group 24</p></div>
				</div>

				<!-- Footer About -->
				<div class="col-lg-6 footer_col">
					<div class="footer_about">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris scelerisque, at rutrum nulla dictum. Ut ac ligula sapien. Suspendisse cursus faucibus finibus. Ut non justo eleifend, facilisis nibh ut, interdum odio.</p>
					</div>
				</div>

				<!-- Footer Contact -->
				<div class="col-lg-3 footer_col">
					<div class="footer_contact">
						<ul>
							<li class="d-flex flex-row align-items-start justify-content-start">
								<div><div class="footer_contact_title">Address:</div></div>
								<div class="footer_contact_text">sdbb</div>
							</li>
							<li class="d-flex flex-row align-items-start justify-content-start">
								<div><div class="footer_contact_title">Phone:</div></div>
								<div class="footer_contact_text">+1 979 412 9915</div>
							</li>
							<li class="d-flex flex-row align-items-start justify-content-start">
								<div><div class="footer_contact_title">Contact:</div></div>
								<div class="footer_contact_text">contact@cloudbar.com</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>

</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap-4.1.2/popper.js"></script>
<script src="styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/jquery-datepicker/jquery-ui.js"></script>
<script src="plugins/jquery-timepicker/jquery.timepicker.js"></script>
<script src="js/menu.js"></script>
</body>
</html>