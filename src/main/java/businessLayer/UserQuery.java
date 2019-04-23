package businessLayer;

public class UserQuery {
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getWebsiteUrl() {
			return websiteUrl;
		}
		public void setWebsiteUrl(String websiteUrl) {
			this.websiteUrl = websiteUrl;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		private String email;
		private String contact;
		private String websiteUrl;
		private String message;
		
}
