package businessLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import databaseLayer.DatabaseConnection;

public class ProductLogic {
	public LinkedHashMap<String,ArrayList<Product>> getAllProducts(String product, String city){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchAllProducts(product,city);
	}
	public ArrayList<Product> getAllProducts(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchAllProducts();
	}
	public boolean deleteProduct(String productId) {
		DatabaseConnection dc = new DatabaseConnection();
		return dc.deleteProduct(productId);
	}
}
