package com.stocks.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuperSimpleStockMarket {
	private static final Logger LOGGER = Logger.getLogger(SuperSimpleStockMarket.class.getName());
	private static final float FIFTEEN_MINUTES = 15 * 60 * 1000;
	static List<Stock> currentStocks=null;
	static List<Stock> currentTrades=null;
	
	public static void main(String[] args) {
	      renderMenu();
	      fillStocks();
	      int optionMenu=getOption();
	      stockOptions(optionMenu);
	      
	}

	private static void renderMenu(){
		  System.out.println("=======================================================\n");
	      System.out.println("\t\tSuperSimple StockMarket\n");
	      System.out.println("=======================================================\n");
	      System.out.println("1. View Stocks List\n");
	      System.out.println("2. Calculate the Divident Yield\n");
	      System.out.println("3. Calculate the PE Ratio\n");
	      System.out.println("4. Record a Trade\n");
	      System.out.println("5. Calculate Volume Weighted Stock Price based on trades in past 15 minutes\n");
	      System.out.println("6. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks\n");
	      System.out.println("7. Exit\n");
	      System.out.println("Give an Option: ");
	}
	

	private static void stockOptions(int option){
		switch (option){
	
		case 1:
			showStocks();
			break;
		case 2:
			System.out.println("Calculating Divident Yield, give the price:\n");
			int price=getPrice();
			System.out.println("Choose the stock");
			showStocks();
			int stockNumber=getStock();
			Stock stock=currentStocks.get(stockNumber);
			stock.setPrice(price);
			calculateYieldDivident(stock);
			break;
		case 3:
			System.out.println("Calculating PE Ratio, give the price:\n");
			int price1=getPrice();
			System.out.println("Choose the stock");
			showStocks();
			int stockNumber1=getStock();
			Stock stock1=currentStocks.get(stockNumber1);
			stock1.setPrice(price1);
			calculatePERatio(stock1);
			break;
		case 4:
			System.out.println("Recording a Trade, give the quantity of shares:\n");
			int shares=getQuantityShares();
			System.out.println("Choose the TradedPrice");
			int tradedPrice=getPrice();
			java.util.Date date= new java.util.Date();
			 Timestamp tmpAux=new Timestamp(date.getTime());
			Trade trade= newTrade(tmpAux,shares,getTradeIndicator(),getPrice());
			break;
		case 5:
			
			break;
		case 6:
			break;
		case 7:
			System.exit(0); 
		}
		
	}
	private static Trade newTrade(Timestamp timestamp, int shares, String tradeIndicator, int price) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void showStocks(){
		System.out.println("\nSTOCKSYMBOL\tSTOCKTYPE\tLASTDIVIDENT\tFIXED DIVIDENT \tPAR VALUE \tPRICE\n");
		System.out.println("=================================================================================");
		int i=0;
		for(Stock s:currentStocks){
			System.out.println(i+s.getStockSimbol()+"\t\t"+s.getStockType()+"\t\t"+s.getLastDividend()+"\t\t"+s.getFixedDividend()+"\t\t"+s.getParValue()+"\t\t"+s.getPrice()+"\n");
			i++;
		}
	}
	private static void fillStocks(){
		currentStocks=new ArrayList<Stock>();
		Stock stock1=new Stock(SymbolEnum.TEA.getName(),TypeEnum.COMMON.getName(),0,0,100,0);
		Stock stock2=new Stock(SymbolEnum.POP.getName(),TypeEnum.COMMON.getName(),8,0,100,0);
		Stock stock3=new Stock(SymbolEnum.ALE.getName(),TypeEnum.COMMON.getName(),23,0,60,0);
		Stock stock4=new Stock(SymbolEnum.GIN.getName(),TypeEnum.PREFERRED.getName(),8,2,100,0);
		Stock stock5=new Stock(SymbolEnum.JOE.getName(),TypeEnum.COMMON.getName(),13,0,250,0);
		currentStocks.add(stock1);
		currentStocks.add(stock2);
		currentStocks.add(stock3);
		currentStocks.add(stock4);
		currentStocks.add(stock5);
	}
	private static void calculateYieldDivident(Stock stock){
		float divYield=0;
		if(stock.getStockType().equals(TypeEnum.PREFERRED.getName())){ 
			divYield=(float)(stock.getFixedDividend()*stock.parValue)/stock.getPrice();
		}else{
			divYield=(float)stock.getLastDividend()/stock.getPrice();
		}
		System.out.println("And the Divident Yield is:"+divYield);
	}
	private static void calculatePERatio(Stock stock1){
		float peRatio=0;
		if(stock1.getStockType().equals(TypeEnum.PREFERRED.getName())){ 
			peRatio=(float)(stock1.getPrice()/stock1.getFixedDividend());
		}else{
			peRatio=(float)(stock1.getPrice()/stock1.getLastDividend());
		}
		System.out.println("And the PE Ratio is:"+peRatio);
	}
	public static void calculate15MinTrade(Trade trade){
		 java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

		//String result = DateUtils.getRelativeTimeSpanString(1306767830, 1306767835, 0);
	}
	@SuppressWarnings("unused")
	private static int getPrice(){
		int price=0;
        String priceString; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            priceString = br.readLine(); 
            price = Integer.parseInt(priceString); //We validate is an integer 
        }
        catch(Exception e){
        	LOGGER.log(Level.SEVERE, "Type a valid price");
			SuperSimpleStockMarket stockMarket = new SuperSimpleStockMarket(); 
        }
        return price;
	}
	@SuppressWarnings("unused")
	private static int getStock(){
		int stock=0;
        String stockString; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            stockString = br.readLine(); 
            stock = Integer.parseInt(stockString); //We validate is an integer 
            if(stock>currentStocks.size()){
            	throw new Exception();
            }
        }
        catch(Exception e){
        	LOGGER.log(Level.SEVERE, "Type a valid number");
            SuperSimpleStockMarket stockMarket = new SuperSimpleStockMarket(); 
        }
        return stock;
	}
	@SuppressWarnings("unused")
	private static int getOption(){
		int option=0;
        String optionString; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            optionString = br.readLine(); 
            option = Integer.parseInt(optionString); //We validate is an integer 
        }
        catch(Exception e){
        	LOGGER.log(Level.SEVERE, "Type a valid number");
			SuperSimpleStockMarket stockMarket = new SuperSimpleStockMarket(); 
        }
        return option;
	}
	
	@SuppressWarnings("unused")
	private static int getQuantityShares(){
		int share=0;
        String shareString; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            shareString = br.readLine(); 
            share = Integer.parseInt(shareString); //We validate is an integer 
        }
        catch(Exception e){
        	LOGGER.log(Level.SEVERE, "Type a valid Quantity of Shares");
			SuperSimpleStockMarket stockMarket = new SuperSimpleStockMarket(); 
        }
        return share;
	}
	@SuppressWarnings("unused")
	private static String getTradeIndicator(){
		
		String tradeIndicator = null; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        	tradeIndicator = br.readLine(); 
            if(tradeIndicator.equals(TradeTypeEnum.BUY.getName()) || tradeIndicator.equals(TradeTypeEnum.SELL.getName())){
            	return tradeIndicator;
            }else{
            	throw new Exception();
            } 
        }
        catch(Exception e){
        	LOGGER.log(Level.SEVERE, "Type a valid Trade Indicator");
			SuperSimpleStockMarket stockMarket = new SuperSimpleStockMarket(); 
        }
        return tradeIndicator;
	}
}
