package businessLayer;

import databaseLayer.DatabaseConnection;
import presentationLayer.Order;

public class OrderLogic {
	public boolean insertOrderDetails(Order order) {
		DatabaseConnection dc = new DatabaseConnection();
		return dc.insertOrderDetails(order);
	}
}
