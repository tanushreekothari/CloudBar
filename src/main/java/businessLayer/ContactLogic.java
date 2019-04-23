package businessLayer;

import databaseLayer.DatabaseConnection;

public class ContactLogic {
		public boolean insertUserQuery(UserQuery userquery) {
			DatabaseConnection dc = new DatabaseConnection();
			return dc.insertUserQuery(userquery);
		}
}
