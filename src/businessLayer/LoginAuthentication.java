package businessLayer;

import java.util.HashMap;

import databaseLayer.DatabaseConnection;

public class LoginAuthentication {
	public HashMap<String, String> fetchPasswordAndName(String username){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchPasswordAndName(username);
	}
}
