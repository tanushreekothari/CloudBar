package presentationLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import businessLayer.Product;
import businessLayer.ProductLogic;

public class ProductInfo {
	
	public LinkedHashMap<String,ArrayList<Product>> getAllProducts(){
		ProductLogic pl = new ProductLogic();
		return pl.getAllProducts();
	}

}
