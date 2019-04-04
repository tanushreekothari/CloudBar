package presentationLayer;

import java.util.ArrayList;
import java.util.HashMap;

import businessLayer.Offer;
import businessLayer.OfferInfoLogic;

public class OfferInfo{
	
	public String getOfferDesc(){
			OfferInfoLogic ol = new OfferInfoLogic();
			return ol.getOfferInfo().get("offerdesc");
	}
	
	public String getOfferCost(){
		OfferInfoLogic ol = new OfferInfoLogic();
		return ol.getOfferInfo().get("offercost");
	}
	
	public HashMap<String,ArrayList<Offer>> getTopOffers(){
		OfferInfoLogic ol = new OfferInfoLogic();
		return ol.getTopOffersInfo();
	}
}
