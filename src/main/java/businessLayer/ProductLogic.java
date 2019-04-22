package businessLayer;

import java.util.ArrayList;
import java.util.HashMap;

import databaseLayer.DatabaseConnection;

public class ProductLogic {
	public HashMap<String,ArrayList<Product>> getAllProducts(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchAllProducts();
	}
}
