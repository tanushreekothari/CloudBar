package businessLayer;

import java.util.ArrayList;

import databaseLayer.DatabaseConnection;

public class BarLogic {
		public ArrayList<BarAgent> getAllBarAgents(){
				DatabaseConnection dc = new DatabaseConnection();
				return dc.fetchAllBarAgents();
		}
		public boolean deleteBarAgent(int barId) {
			DatabaseConnection dc = new DatabaseConnection();
			return dc.deleteBarAgent(barId);
		}

}
