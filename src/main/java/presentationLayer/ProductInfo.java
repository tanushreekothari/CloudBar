package presentationLayer;

import java.util.ArrayList;
import java.util.HashMap;

import businessLayer.Product;
import businessLayer.ProductLogic;

public class ProductInfo {
	
	public HashMap<String,ArrayList<Product>> getAllProducts(){
		ProductLogic pl = new ProductLogic();
		return pl.getAllProducts();
	}

}
