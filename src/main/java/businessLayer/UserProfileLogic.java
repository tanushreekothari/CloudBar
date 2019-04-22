package businessLayer;

import databaseLayer.DatabaseConnection;

public class UserProfileLogic {
		public boolean createUserProfile(User user) {
			DatabaseConnection dc = new DatabaseConnection();
			return dc.insertUserDetails(user);
		}
}
