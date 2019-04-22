package presentationLayer;

import java.util.ArrayList;

import businessLayer.Blog;
import businessLayer.BlogLogic;

public class BlogInfo {
		public ArrayList<Blog> getAllBlogs(){
			BlogLogic bl = new BlogLogic();
			return bl.getAllBlogs();
		}
}
