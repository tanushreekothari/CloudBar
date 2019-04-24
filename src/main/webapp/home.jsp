<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="presentationLayer.CloudBarPresentation"%>
<%@ page import="presentationLayer.DropDownItemsList"%>
<%@ page import="presentationLayer.OfferInfo"%>
<%@ page import="businessLayer.Offer"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cloud Bar</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="We provide Alcohol-as-a-Service">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link href="plugins/jquery-datepicker/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="plugins/jquery-timepicker/jquery.timepicker.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

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
  		<div class="menu_reservations_phone ml-auto"><a href="">Hi <%=userName %></a></div>
  	<form action="LogoutServlet" method="post">	<div class="menu_reservations_phone1 ml-auto"><input type="submit" value="LOGOUT" style="background-color: Transparent;
      background-repeat:no-repeat;
      border: none;
      cursor:pointer;
      overflow: hidden;
      outline:none; color:white;" ></div></form>
  	</div>

	<!-- Home -->

	<div class="home">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/home.jpg" data-speed="0.8"></div>
		<div class="home_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="home_content text-center">
							<div class="home_subtitle page_subtitle">Cloud Bar</div>
							<div class="home_title"><h1>Reserve your Liquor on the Cloud</h1></div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="scroll_icon"></div>
	</div>
<section class="search-sec">
    <div class="container">
        <form action="OfferServlet" method="post">
        
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <select class="form-control search-slt" name="state" id="exampleFormControlSelect1">
                                <option>Select State</option>
                                <option>Texas</option>
                            </select>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <select class="form-control search-slt" name="city" id="exampleFormControlSelect2">
                                <option>Select City</option>
        <%
        DropDownItemsList dl = new DropDownItemsList();
        ArrayList<String> al = dl.getCityList();
        for(String cityVal: al){ %>
            <option value="<%= cityVal%>"><%= cityVal%></option>
        <% } %>
                            </select>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <select class="form-control search-slt" name="product" id="exampleFormControlSelect3">
                                <option value="select">Choose your Booze</option>
                                  <%
        ArrayList<String> alProd = dl.getProductList();
        for(String prodVal: alProd){ %>
            <option value="<%= prodVal%>"><%= prodVal%></option>
        <% } %>


                            </select>

                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <input type="submit" value="Search" class="btn btn-danger wrn-btn" >
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
	<!-- Intro -->
	

	<div class="intro">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="intro_content">

						<div class="intro_title"><h2>About Us</h2></div>
						<div class="intro_text">
							<p>Cloud Bar aims to push liquors on virtual clouds and provide alcohol-as-a-service to liquor connoisseurs with a vision to regulate prices. Cloud Bar is a digital platform based out of College Station, Texas that allows its customers to purchase any liquor from authorized sellers and reserve a digital copy of their liquor bottle in their personalized virtual digital bars readily available on the web platform.</p>
						</div>
					</div>
					<div class="row">
						<div class="col-xl-4 col-md-6 intro_col">
							<div class="intro_image"><img src="images/art-bar-beautiful-1801106.jpg" alt="https://unsplash.com/@quanle2819"></div>
						</div>
						<div class="col-xl-4 col-md-6 intro_col">
							<div class="intro_image"><img src="images/bar-building-business-1297465.jpg" alt="https://unsplash.com/@fabmag"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Video -->

	<div class="video_section">
		<div class="background_image" style="background-image:url(images/alcohol-bar-beverage-1660560.jpg); filter:brightness(60%)"></div>
		<div class="video_section_content d-flex flex-column align-items-center justify-content-center text-center">
			<div class="video_section_title">Reserve your Liquor on Cloud</div>
			<div class="video_section_icon"><a class="vimeo video_button" href="https://player.vimeo.com/video/99340873?autoplay=1&loop=1&title=0&autopause=0"><i class="fa fa-play" aria-hidden="true"></i></a></div>
		</div>
	</div>

	<!-- Signature Dish -->

	<div class="sig" id="sig">
		<div class="sig_content_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-7">
						<div class="sig_content">
						<%OfferInfo obj = new OfferInfo(); %>
							<div class="sig_subtitle page_subtitle">Deal of the day</div>
							<div class="sig_title"><h1>Our Top Pick for You</h1></div>
							<div class="rating_r sig_rating rating_r_5"><i></i><i></i><i></i><i></i><i></i></div>
							<div class="sig_name_container d-flex flex-row align-items-start justify-content-start">
								<div class="sig_name" id ="disp2"><%=obj.getOfferDesc()%></div>
								<div class="sig_price ml-auto" id ="disp1">$<%=obj.getOfferCost()%></div>
							</div>

							<div class="sig_content_list">
								<ul class="d-flex flex-row align-items-center justify-content-start">
									<li id ="disp"><%=obj.getOfferCategory()%></li>
								</ul>
							</div>
							<div class="button sig_button trans_200"><a href="offers.jsp">Check Out Offer</a></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="sig_image_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-7 offset-lg-5">
						<div class="sig_image">
							<div class="background_image" style="background-image:url(images/alcohol-bottle-drink-64738.jpg)"></div>
							<img src="images/alcohol-bottle-drink-64738.jpg" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- The Menu -->

	<div class="themenu">
	<form action="OrderServlet" method="post">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="themenu_title_bar_container">
						<div class="themenu_stars text-center page_subtitle">Offers</div>
						<div class="themenu_rating text-center">
							<div class="rating_r rating_r_5"><i></i><i></i><i></i><i></i><i></i></div>
						</div>
						<div class="themenu_title_bar d-flex flex-column align-items-center justify-content-center">
							<div class="themenu_title">Special Deals</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row themenu_row">
<%  HashMap<String,ArrayList<Offer>> offers = obj.getTopOffers();
%>
				<!-- Starters -->
				<%

      						  for(String offer: offers.keySet()){ %>
				<div class="col-lg-4 themenu_column">
					<div class="themenu_col">
						<div name="bar" class="themenu_col_title"><%=offer %></div>
						<div class="dish_list">

							<!-- Dish -->
							                       <%
       				 ArrayList<Offer> objOffers = offers.get(offer);
      						  for(Offer objOffer: objOffers){ %>
							<div class="dish">
								<div class="dish_title_container d-flex flex-xl-row flex-column align-items-start justify-content-start">
									<div name="liquor" class="dish_title"><%= objOffer.getOfferName()%></div>
									<div name="cost" class="dish_price">$<%= objOffer.getOfferCost()%></div>
								</div>
								<div class="dish_contents">
									<ul class="d-flex flex-row align-items-start justify-content-start flex-wrap">
										<li><%= objOffer.getOfferCategory()%></li>
									</ul>
								</div>
								<div class="dish_order"><input type="submit" value="Order Now"></div>
							</div>
								<% } %>
						</div>
					</div>
				</div>
<% } %>


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
								<div class="footer_contact_text">on the clouds</div>
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
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="plugins/jquery-datepicker/jquery-ui.js"></script>
<script src="plugins/jquery-timepicker/jquery.timepicker.js"></script>
<script src="js/custom.js"></script>
</body>

</html>
