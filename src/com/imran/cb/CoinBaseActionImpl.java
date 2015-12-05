package com.imran.cb;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.coinbase.exchange.api.CoinbaseExchange;
import com.coinbase.exchange.api.CoinbaseExchangeBuilder;
import com.coinbase.exchange.api.entity.Product;
import com.coinbase.exchange.api.entity.ProductOrderBook;
import com.coinbase.exchange.api.entity.Stats;

public class CoinBaseActionImpl implements CoinBaseAction {
	
	private static CoinBaseActionImpl instance = null;
	private CoinbaseExchange coinbaseExchange;
	private String productID = "BTC-CAD";
	
	public CoinBaseActionImpl() {
	}

	public CoinBaseActionImpl(CoinbaseExchange coinbaseExchange) {
		this.coinbaseExchange = coinbaseExchange;
	}
	

	@Override
	public double getTrendPercentage() throws NumberFormatException, ClientProtocolException, IOException {
		
		System.out.println("Start Trend Percentage");
		
		
		for(Product product: coinbaseExchange.getProducts())
		{
			double askVolume = 0.0d;
			double bidVolume = 0.0d;
			if(product.getId().equals(productID)){
			
				Stats stats= coinbaseExchange.getStats(product);
				
		
				ProductOrderBook  productOrderBook = coinbaseExchange.getMarketDataProductOrderBook(product.getId(),"2");
				
				for(List<String> asks : productOrderBook.getAsks()){
					askVolume += Double.valueOf(asks.get(1));
					
				}
				
				for(List<String> bids : productOrderBook.getBids()){
					bidVolume += Double.valueOf(bids.get(1));
					//bidVolume.add(BigDecimal.valueOf(Double.valueOf(bids.get(1))));
				}
				
				//as = askVolume + bidVolume
				
			}	
			
			
		}
		return 0.0d;

	}
}
