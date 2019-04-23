package presentationLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import businessLayer.Product;
import businessLayer.ProductLogic;


public class ProductInfo {
	
	public LinkedHashMap<String,ArrayList<Product>> getAllProducts(String product, String city){
		ProductLogic pl = new ProductLogic();
		return pl.getAllProducts(product,city);
	}
	public ArrayList<Product> getAllProducts(){
		ProductLogic pl = new ProductLogic();
		return pl.getAllProducts();
	}
	public boolean deleteProduct(String productId) {
		ProductLogic pl = new ProductLogic();
		return pl.deleteProduct(productId);
	}

}
