package businessLayer;

import java.util.ArrayList;
import java.util.HashMap;

import databaseLayer.DatabaseConnection;

public class OfferInfoLogic {
	public HashMap<String, String> getOfferInfo(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchOfferInfo();
	}
	public HashMap<String,ArrayList<Offer>> getTopOffersInfo(){
		DatabaseConnection dc = new DatabaseConnection();
		return dc.fetchTopOffers();
	}
}
