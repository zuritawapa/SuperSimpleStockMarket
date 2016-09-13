package com.stocks.net;

public enum SymbolEnum {

		TEA("TEA"),
		POP("POP"),
		ALE("ALE"),
		GIN("GIN"),
		JOE("JOE");
	    private String name;

	    SymbolEnum(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
}
