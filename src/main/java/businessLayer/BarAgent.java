package businessLayer;

public class BarAgent {
	private int barId;
	public int getBarId() {
		return barId;
	}
	public void setBarId(int barId) {
		this.barId = barId;
	}
	public String getBarName() {
		return barName;
	}
	public void setBarName(String barName) {
		this.barName = barName;
	}
	public int getBarRank() {
		return barRank;
	}
	public void setBarRank(int barRank) {
		this.barRank = barRank;
	}
	public double getBarWeight() {
		return barWeight;
	}
	public void setBarWeight(double barWeight) {
		this.barWeight = barWeight;
	}
	public int getIsSponsored() {
		return isSponsored;
	}
	public void setIsSponsored(int isSponsored) {
		this.isSponsored = isSponsored;
	}
	private String barName;
	private int barRank;
	private double barWeight;
	private int isSponsored;

}
