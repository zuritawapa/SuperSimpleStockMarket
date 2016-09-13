package com.stocks.net;

public enum TradeTypeEnum {

	 	BUY("Buy"),
	    SELL("Sell");

	    private String name;

	    TradeTypeEnum(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
}
