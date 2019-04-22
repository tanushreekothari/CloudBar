package businessLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import databaseLayer.DatabaseConnection;

public class ProductLogic {
	public LinkedHashMap<String,ArrayList<Product>> getAllProducts(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchAllProducts();
	}
}
