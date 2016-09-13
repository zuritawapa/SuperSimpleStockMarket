package com.stocks.net;

import java.security.Timestamp;

public class Trade {
	
	Timestamp timeStamp;
	int sharesQuantity;
	String tradeTypeIndicator;
	int tradedPrice;
	
	public Trade(Timestamp timeStamp,int sharesQuantity,String tradeTypeIndicator,int tradedPrice) {
		this.timeStamp = timeStamp;
		this.sharesQuantity = sharesQuantity;
		this.tradeTypeIndicator = tradeTypeIndicator;
		this.tradedPrice = tradedPrice;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getSharesQuantity() {
		return sharesQuantity;
	}

	public void setSharesQuantity(int sharesQuantity) {
		this.sharesQuantity = sharesQuantity;
	}

	public String getTradeTypeIndicator() {
		return tradeTypeIndicator;
	}

	public void setTradeTypeIndicator(String tradeTypeIndicator) {
		this.tradeTypeIndicator = tradeTypeIndicator;
	}

	public int getTradedPrice() {
		return tradedPrice;
	}

	public void setTradedPrice(int tradedPrice) {
		this.tradedPrice = tradedPrice;
	}
	
	
}
