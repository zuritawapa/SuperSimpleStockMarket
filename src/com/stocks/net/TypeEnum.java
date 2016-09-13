package com.stocks.net;

public enum TypeEnum {

	 	PREFERRED("Preferred"),
	    COMMON("Common");

	    private String name;

	    TypeEnum(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
}
