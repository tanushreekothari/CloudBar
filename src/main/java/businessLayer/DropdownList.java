package businessLayer;

import java.util.ArrayList;

import databaseLayer.DatabaseConnection;

public class DropdownList {
	public ArrayList<String> getCityList(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchCityList();
	}
	public ArrayList<String> getProductList(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchProductList();
	}
}
