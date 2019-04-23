package databaseLayer;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import businessLayer.Offer;
import businessLayer.Product;
import businessLayer.User;
import businessLayer.Blog;
import businessLayer.User;
import businessLayer.UserQuery;
import presentationLayer.Order;
import businessLayer.BarAgent;
public class DatabaseConnection {
	public HashMap<String, String> fetchPasswordAndName(String username) {
		HashMap<String, String> map  = new HashMap<String, String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select password,firstname from userprofile where emailid=?");
			stmt.setString(1,username);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
			 map.put("pass",rs.getString(1));
			 map.put("name",rs.getString(2));
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		System.out.print(map.get("pass"));
		return map;
	}
	public HashMap<String, String> fetchOfferInfo() {
		HashMap<String, String> map  = new HashMap<String, String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select li.LiquorName, b.PriceOffered,li.LiquorDescription from BarLiquorAssociative b inner join LiquorInfo li on b.LiquorID=li.LiquorID\n" +
					"inner join BarAgents ba\n" +
					"on ba.BarID=b.BarID\n" +
					"inner join Locations l\n" +
					"on ba.LocationID=l.LocationID\n" +
					"inner join Products p\n" +
					"on li.ProductID=p.ProductID\n" +
					"where b.isActive=1 \n" +
					"and b.OfferExpiry>now()\n" +
					"order by b.OfferExpiry asc limit 1");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
			 map.put("offerdesc",rs.getString(1));
			 map.put("offercost",rs.getInt(2)+"");
			 map.put("offercateg",rs.getString(3));
			}
			con.close();
			}
		catch(Exception e)
		{
			e.printStackTrace();
			map.put("offerdesc","Offer");
			map.put("offercost","20");
		}
		System.out.print(map.get("offerdesc"));
		return map;
	}

	public ArrayList<String> fetchCityList() {
		ArrayList<String> list  = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select locationcity from locations");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
			 list.add(rs.getString(1));
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);
			list.add("test");
		}
		System.out.print(list.get(0));
		return list;
	}
	public ArrayList<String> fetchProductList() {
		ArrayList<String> list  = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select productname from products");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
			 list.add(rs.getString(1));
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);
				list.add("test");
		}
		System.out.print(list.get(0));
		return list;
	}
	public HashMap<String,ArrayList<Offer>> fetchTopOffers(){
		HashMap<String,ArrayList<Offer>> map= new HashMap<String,ArrayList<Offer>>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select barname from baragents where issponsored=1 order by barweight desc LIMIT 3");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				String temp = rs.getString(1);
			 map.put(temp,fetchFeaturedOffers(temp));
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);
			Offer temp = new Offer();
			temp.setOfferCategory("Sample");
			temp.setOfferCost("20");
			temp.setOfferName("Sample");
			Offer temp1 = new Offer();
			temp1.setOfferCategory("Sample");
			temp1.setOfferCost("20");
			temp1.setOfferName("Sample");
			ArrayList<Offer> list = new ArrayList<Offer>();
			list.add(temp);
			list.add(temp1);
			map.put("Sample Bar",list);
		}
		return map;
	}
	public ArrayList<Offer> fetchFeaturedOffers(String org){
		ArrayList<Offer> list = new ArrayList<Offer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("SELECT LIQUORNAME,LIQUORDESCRIPTION,PRICEOFFERED FROM BARLIQUORASSOCIATIVE BLA INNER JOIN BARAGENTS BA ON BLA.BARID=BA.BARID INNER JOIN LIQUORINFO L ON L.LIQUORID=BLA.LIQUORID WHERE BA.BARNAME=?");
			stmt.setString(1,org);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				Offer temp = new Offer();
				temp.setOfferCategory(rs.getString(2));
				temp.setOfferCost(rs.getString(3));
				temp.setOfferName(rs.getString(1));
			 list.add(temp);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);
		}
		System.out.print(list.get(0));
		return list;
	}
	public LinkedHashMap<String,ArrayList<Product>> fetchAllProducts(String product, String city){
	LinkedHashMap<String,ArrayList<Product>> mapProducts = new LinkedHashMap<String,ArrayList<Product>>();
	mapProducts.put("Vodka",fetchProducts("Vodka"));
	mapProducts.put("Whiskey",fetchProducts("Whiskey"));
	mapProducts.put("Wine",fetchProducts("Wine"));
	return mapProducts;
}
public ArrayList<Product> fetchProducts(String prodCateg){
	ArrayList<Product> list = new ArrayList<Product>();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
		//here cloudBar is database name, root is username and password
		PreparedStatement stmt=con.prepareStatement("select LiquorDescription,LiquorName,PriceOffered from LiquorInfo l inner join BarLiquorAssociative b where l.LiquorID = b.LiquorID and b.barID=1");
	//	stmt.setString(1,org);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())  {
			Product temp = new Product();
			temp.setProductVendor(rs.getString(1));
			temp.setProductCost(rs.getString(3));
			temp.setProductName(rs.getString(2));
		 list.add(temp);
		}
		con.close();
		}
	catch(Exception e)
	{ System.out.println(e);}
	System.out.print(list.get(0));
	return list;
}
public boolean insertUserDetails(User user) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/cloudBar?autoReconnect=true&useSSL=false","root","password");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("insert into userprofile values (?,?,?,?,?,current_date())");
			stmt.setString(1,user.getEmailId());
			stmt.setString(2,user.getFirstName());
			stmt.setString(3,user.getLastName());
			stmt.setString(4,user.getPassword());
			stmt.setString(5,user.getContact());
			int i=stmt.executeUpdate();
			if(i==1) {
				return true;
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return false;
	}
	public ArrayList<Blog> fetchAllBlogs(){
			ArrayList<Blog> list = new ArrayList<Blog>();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(
				"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
				PreparedStatement stmt=con.prepareStatement("SELECT blogDate, blogTitle,blogAuthor,blogContent FROM userblog limit 6");
			//	stmt.setString(1,org);
				ResultSet rs=stmt.executeQuery();
				while(rs.next())  {
					Blog temp = new Blog();
					temp.setTitle(rs.getString(2));
					temp.setAuthor(rs.getString(3));
					temp.setContent(rs.getString(4));
					temp.setDate(rs.getString(1));
				 list.add(temp);
				}
				con.close();
				}
			catch(Exception e)
			{ System.out.println(e);}
			return list;
		}
		public User fetchUserDetails(String emailId) {
	User user = new User();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
				//here cloudBar is database name, root is username and password
		PreparedStatement stmt=con.prepareStatement("select firstname, lastname, password, contactnumber,registrationDate from userprofile where emailid=?");
		stmt.setString(1,emailId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())  {
			user.setFirstName(rs.getString(1));
			user.setLastName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setContact(rs.getString(4));
			user.setDate(rs.getString(5));
		}
		con.close();
		}
	catch(Exception e)
	{ System.out.println(e);}
	return user;
}
public boolean updateUserDetails(User user) {
	try{
		System.out.println("I am updating records");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
				//here cloudBar is database name, root is username and password
		PreparedStatement stmt=con.prepareStatement("UPDATE userprofile SET firstname=?, lastname=?, password=?, contactnumber=? WHERE emailid =?");
		stmt.setString(1,user.getFirstName());
		stmt.setString(2,user.getLastName());
		stmt.setString(3,user.getPassword());
		stmt.setString(4,user.getContact());
		stmt.setString(5,user.getEmailId());
		int i=stmt.executeUpdate();
		if(i==1) {
			System.out.print(i);
			return true;
		}
		con.close();
		}
	catch(Exception e)
	{ System.out.println(e);}
	return false;
}
public ArrayList<User> fetchAllUsers(){
		ArrayList<User> list = new ArrayList<User>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("SELECT emailid, firstname,lastname,contactnumber,registrationdate FROM userprofile");
		//	stmt.setString(1,org);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				User temp = new User();
				temp.setEmailId(rs.getString(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setContact(rs.getString(4));
				temp.setDate(rs.getString(5));
			 list.add(temp);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return list;
	}
	public ArrayList<Product> fetchAllProducts(){
		ArrayList<Product> list = new ArrayList<Product>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("SELECT productid, productname FROM products");
		//	stmt.setString(1,org);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				Product temp = new Product();
				temp.setProductName(rs.getString(2));
				temp.setProductId(rs.getString(1));
			 list.add(temp);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return list;
	}
	public ArrayList<BarAgent> fetchAllBarAgents(){
		ArrayList<BarAgent> list = new ArrayList<BarAgent>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("SELECT barid, barname, barrank, issponsored, barweight FROM baragents");
		//	stmt.setString(1,org);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				BarAgent temp = new BarAgent();
				temp.setBarId(rs.getInt(1));
				temp.setBarName(rs.getString(2));
				temp.setBarRank(rs.getInt(3));
				temp.setBarWeight(rs.getDouble(4));
				temp.setIsSponsored(rs.getInt(5));
			 list.add(temp);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return list;
	}
	public boolean deleteUser(String emailId) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("delete from userprofile WHERE emailid =?");
			stmt.setString(1,emailId);
			int i=stmt.executeUpdate();
			if(i==1) {
				System.out.print(i);
				return true;
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return false;
	}
	public boolean deleteProduct(String productId) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("delete from products WHERE productid =?");
			stmt.setString(1,productId);
			int i=stmt.executeUpdate();
			if(i==1) {
				System.out.print(i);
				return true;
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return false;
	}
	public boolean deleteBarAgent(int barId) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("delete from baragents WHERE barid =?");
			stmt.setInt(1,barId);
			int i=stmt.executeUpdate();
			if(i==1) {
				System.out.print(i);
				return true;
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return false;
	}
	public int getMaxId() {
		int max=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select max(queryid) from userqueries");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				max = rs.getInt(1);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return max;
	}

	public boolean insertUserQuery(UserQuery userQuery) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("insert into userqueries values (?,current_date(),?,?,?,?,?)");
			stmt.setInt(1,getMaxId()+1);
			stmt.setString(2,userQuery.getName());
			stmt.setString(3,userQuery.getEmail());
			stmt.setString(4,userQuery.getContact());
			stmt.setString(5,userQuery.getMessage());
			stmt.setString(6,userQuery.getWebsiteUrl());
			int i=stmt.executeUpdate();
			if(i==1) {
				return true;
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return false;
	}
	public int getMaxOrderId() {
		int max=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
					//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select max(orderid) from heroku_6adf35ad9b60cf9.order");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				max = rs.getInt(1);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}
		return max;
	}
	public boolean insertOrderDetails(Order order) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");//here cloudBar is database name, root is username and password
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("INSERT INTO heroku_6adf35ad9b60cf9.ORDER (ORDERID,EMAILID,ORDERDATE,ORDERSTATUS,BARLIQUORID,VENDORPRODUCTID,ORDERTOTAL)\n" +
					"select ?,?,current_date(),\"Pending\",barliquorid,NULL,bla.priceoffered\n" +
					" from barliquorassociatIVE bla\n" +
					"inner join baragents ba\n" +
					"on ba.barid=bla.barid\n" +
					"inner join liquorinfo l\n" +
					"on bla.liquorid=l.liquorid\n" +
					"where l.liquorname=? \n" +
					"and ba.barname=?");
			stmt.setInt(1,getMaxOrderId()+1);
			stmt.setString(2,order.getEmailId());
			//stmt.setFloat(3,Float.parseFloat(order.getCost().replaceAll("$", "")));
			stmt.setString(3,order.getLiquorName());
			stmt.setString(4,order.getBarName());
			int i=stmt.executeUpdate();
			if(i==1) {
				return true;
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println("I am here");
		e.printStackTrace();
			System.out.println(e);
			}
		return false;
	}

}
