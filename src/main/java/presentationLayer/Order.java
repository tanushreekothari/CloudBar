package presentationLayer;

public class Order {
		private String liquorName;
		private String emailId;
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getLiquorName() {
			return liquorName;
		}
		public void setLiquorName(String liquorName) {
			this.liquorName = liquorName;
		}
		public String getBarName() {
			return barName;
		}
		public void setBarName(String barName) {
			this.barName = barName;
		}
		public String getCost() {
			return cost;
		}
		public void setCost(String cost) {
			this.cost = cost;
		}
		private String barName;
		private String cost;
}
