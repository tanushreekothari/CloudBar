package presentationLayer;

import businessLayer.User;
import businessLayer.UserProfileLogic;

public class UserInfo {

		public User getUserDetails(String emailId) {
			UserProfileLogic dc = new UserProfileLogic();
			return dc.getUserDetails(emailId);
		}
	
}
