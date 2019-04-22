package businessLayer;

import databaseLayer.DatabaseConnection;

public class UserProfileLogic {
		public boolean createUserProfile(User user) {
			DatabaseConnection dc = new DatabaseConnection();
			return dc.insertUserDetails(user);
		}
		public User getUserDetails(String emailId) {
			DatabaseConnection dc = new DatabaseConnection();
			return dc.fetchUserDetails(emailId);
		}
		public boolean updateUserDetails(User user) {
			DatabaseConnection dc = new DatabaseConnection();
			return dc.updateUserDetails(user);
		}
}
