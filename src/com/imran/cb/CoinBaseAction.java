package com.imran.cb;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface CoinBaseAction {
	public double getTrendPercentage() throws NumberFormatException, ClientProtocolException, IOException;
}
