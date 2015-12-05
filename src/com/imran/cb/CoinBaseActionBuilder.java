package com.imran.cb;

import java.security.NoSuchAlgorithmException;

import com.coinbase.exchange.api.CoinbaseExchange;
import com.coinbase.exchange.api.CoinbaseExchangeImpl;

public class CoinBaseActionBuilder {
	
    private static CoinBaseActionImpl coinbaseAction = null;
    
    public CoinBaseAction build(CoinbaseExchange conbaseExchange ) throws NoSuchAlgorithmException {
		      if(coinbaseAction == null) {
		    	  coinbaseAction = new CoinBaseActionImpl(conbaseExchange);
		      }
		      return coinbaseAction;
    }

}
