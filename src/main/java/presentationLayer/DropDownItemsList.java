package presentationLayer;

import java.util.ArrayList;

import businessLayer.DropdownList;



public class DropDownItemsList {
	public ArrayList<String> getCityList(){
		DropdownList dl = new DropdownList();
		return dl.getCityList();
	}
	public ArrayList<String> getProductList(){
		DropdownList dl = new DropdownList();
		return dl.getProductList();
	}
}
