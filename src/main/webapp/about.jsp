<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userName = null;
String product = null;
String city = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("product")) product = cookie.getValue();
	if(cookie.getName().equals("city")) city = cookie.getValue();
}
}

if(userName == null) response.sendRedirect("index.jsp");

%>

<h1><%=userName %></h1>
<h1><%=product %></h1>
<h1><%=city %></h1>
</body>
</html>