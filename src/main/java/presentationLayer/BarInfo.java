package presentationLayer;

import java.util.ArrayList;

import businessLayer.BarAgent;
import businessLayer.BarLogic;
import businessLayer.OrderLogic;

public class BarInfo {
	public ArrayList<BarAgent> getAllBarAgents(){
		BarLogic bl = new BarLogic();
		return bl.getAllBarAgents();
	}
	public boolean deleteBarAgent(int barId) {
		BarLogic dc = new BarLogic();
		return dc.deleteBarAgent(barId);
	}
	public ArrayList<Order> getOrderDetails(String emailId) {
		OrderLogic ol = new OrderLogic();
		return ol.fetchOrderDetails(emailId);
	}
}
