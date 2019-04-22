package businessLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import databaseLayer.DatabaseConnection;

public class ProductLogic {
	public LinkedHashMap<String,ArrayList<Product>> getAllProducts(String product, String city){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchAllProducts(product,city);
	}
}
