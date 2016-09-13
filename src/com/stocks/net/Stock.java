package com.stocks.net;

public class Stock {
	
	String stockSimbol;
	String stockType;
	int lastDividend;
	int fixedDividend;
	int parValue;
	int price;
	
	public Stock(String stockSimbol, String stockType, int lastDividend, int fixedDividend, int parValue, int price) {
		this.stockSimbol=stockSimbol;
		this.stockType=stockType;
		this.lastDividend=lastDividend;
		this.fixedDividend=fixedDividend;
		this.parValue=parValue;
		this.price=price;
	}
	public String getStockSimbol() {
		return stockSimbol;
	}
	public void setStockSimbol(String stockSimbol) {
		this.stockSimbol = stockSimbol;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public int getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(int lastDividend) {
		this.lastDividend = lastDividend;
	}
	public int getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(int fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public int getParValue() {
		return parValue;
	}
	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void calculateDividentYield(Stock stock){
		
		
	}
	
}
