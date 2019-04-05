package databaseLayer;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import businessLayer.Offer;

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
			PreparedStatement stmt=con.prepareStatement("select li.LiquorName, b.PriceOffered from BarLiquorAssociative b inner join LiquorInfo li on b.LiquorID=li.LiquorID\n" +
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
			PreparedStatement stmt=con.prepareStatement("SELECT LIQUORNAME,LIQUORDESCRIPTION FROM BARLIQUORASSOCIATIVE BLA INNER JOIN BARAGENTS BA ON BLA.BARID=BA.BARID INNER JOIN LIQUORINFO L ON L.LIQUORID=BLA.LIQUORID WHERE BA.BARNAME=?");
			stmt.setString(1,org);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				Offer temp = new Offer();
				temp.setOfferCategory(rs.getString(1));
				temp.setOfferCost(rs.getString(3));
				temp.setOfferName(rs.getString(2));
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
}
