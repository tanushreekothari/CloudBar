<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="presentationLayer.OfferInfo"%>
<%@ page import="businessLayer.Offer"%>
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
<style>
.logo img {
    width: 100px;
    height: 50px;
    vertical-align: sub;
    border-style: none;
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
						<div class="reservations_phone ml-auto" style=" border: none;"><a href="profile.jsp">Hi <%=userName %></a></div>
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
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/155590706143305035.jpg" data-speed="0.8"></div>
		<div class="home_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="home_content text-center">
							<div class="home_subtitle page_subtitle">Cloud Bar</div>
							<div class="home_title"><h1>Offers</h1></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	
	
	<!-- Signature Dishes -->

	<div class="sig">
	<form action="OrderServlet" method="post">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container">
						<div class="section_subtitle page_subtitle">Cheers!</div>
						<div class="section_title"><h1>Checkout Our Offers</h1></div>
					</div>
				</div>
			</div>
			<div class="row sig_row">
				<div class="col">
					<%OfferInfo obj = new OfferInfo();  
					HashMap<String,ArrayList<Offer>> offers = obj.getTopOffers();
					 for(String offer: offers.keySet()){
					 ArrayList<Offer> objOffers = offers.get(offer);
      						  for(Offer objOffer: objOffers){%>
					<!-- Signature Dish -->
					<div class="sig_dish">
						<div class="row row-eq-height">
							<div class="col-lg-6 sig_col d-flex flex-column align-items-start justify-content-center">
								<div class="sig_content">
									<div class="rating_r sig_rating rating_r_5"><i></i><i></i><i></i><i></i><i></i></div>
									<div class="sig_name_container d-flex flex-row align-items-start justify-content-start">
										<div class="sig_name"><%=objOffer.getOfferName()%></div>
										<div class="sig_price ml-auto">$<%= objOffer.getOfferCost()%></div>
									</div>
									<div class="sig_content_list">
										<ul class="d-flex flex-row align-items-center justify-content-start">
											<li><%= offer%></li>
										</ul>
									</div>
									<input type="submit" value="Order Now" style="background-color: #108cb2;
								padding:5px;
      background-repeat:no-repeat;
      font-size:20px;
      border: none;
      cursor:pointer;
      overflow: hidden;
      outline:none; color:white;
      
      "></div>
								
							</div>
							<div class="col-lg-6 sig_col">
								<div class="sig_image"><img src="<%=objOffer.getImageUrl() %>" alt=""></div>
							</div>
						</div>
					</div>
<% } }%>				
					

				</div>
			</div>
		</div>
		</form>
	</div>

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
						</div>
				</div>

				<!-- Footer Contact -->
				<div class="col-lg-3 footer_col">
					<div class="footer_contact">
						<ul>
							<li class="d-flex flex-row align-items-start justify-content-start">
								<div><div class="footer_contact_title">Address:</div></div>
								<div class="footer_contact_text">On the clouds</div>
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