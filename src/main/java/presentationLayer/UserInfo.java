package presentationLayer;

import java.util.ArrayList;

import businessLayer.User;
import businessLayer.UserProfileLogic;

public class UserInfo {

		public User getUserDetails(String emailId) {
			UserProfileLogic dc = new UserProfileLogic();
			return dc.getUserDetails(emailId);
		}
		public ArrayList<User> getAllUsers() {
			UserProfileLogic dc = new UserProfileLogic();
			return dc.getAllUsers();
		}
		public boolean deleteUser(String emailId) {
			UserProfileLogic dc = new UserProfileLogic();
			return dc.deleteUser(emailId);
		}
	
}
