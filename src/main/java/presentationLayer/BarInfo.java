package presentationLayer;

import java.util.ArrayList;

import businessLayer.BarAgent;
import businessLayer.BarLogic;

public class BarInfo {
	public ArrayList<BarAgent> getAllBarAgents(){
		BarLogic bl = new BarLogic();
		return bl.getAllBarAgents();
	}
	public boolean deleteBarAgent(int barId) {
		BarLogic dc = new BarLogic();
		return dc.deleteBarAgent(barId);
	}

}
