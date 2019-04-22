package databaseLayer;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import businessLayer.Offer;
import businessLayer.Product;
import businessLayer.User;

public class DatabaseConnection {
	public HashMap<String, String> fetchPasswordAndName(String username) {
		HashMap<String, String> map  = new HashMap<String, String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("select password,firstname from userprofile where username=?");
			stmt.setString(1,username);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
			 map.put("pass",rs.getString(1));
			 map.put("name",rs.getString(2));
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);
			map.put("pass","pass");
			map.put("name","Trish");
		}
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
	public LinkedHashMap<String,ArrayList<Product>> fetchAllProducts(){
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
		HashMap<String, String> map  = new HashMap<String, String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_6adf35ad9b60cf9?autoReconnect=true&useSSL=false","be084cc3a55986","2519352e");
			//here cloudBar is database name, root is username and password
			PreparedStatement stmt=con.prepareStatement("insert into userprofile values (?,?,?,?,?,?,current_date())");
			stmt.setString(1,user.getEmailId());
			stmt.setString(2,user.getUserName());
			stmt.setString(3,user.getFirstName());
			stmt.setString(4,user.getLastName());
			stmt.setString(5,user.getPassword());
			stmt.setString(6,user.getContact());
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
}
