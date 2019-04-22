package businessLayer;

import java.util.ArrayList;

import databaseLayer.DatabaseConnection;

public class BlogLogic {
	public ArrayList<Blog> getAllBlogs(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchAllBlogs();
	}
}
