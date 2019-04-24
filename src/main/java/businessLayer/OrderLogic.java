package businessLayer;

import java.util.ArrayList;

import databaseLayer.DatabaseConnection;
import presentationLayer.Order;

public class OrderLogic {
	public boolean insertOrderDetails(Order order) {
		DatabaseConnection dc = new DatabaseConnection();
		return dc.insertOrderDetails(order);
	}
	
	public ArrayList<Order> fetchOrderDetails(String emailId) {
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchOrderDetails(emailId);
	}
}
