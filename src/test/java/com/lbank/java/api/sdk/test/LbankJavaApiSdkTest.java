package com.lbank.java.api.sdk.test;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbank.java.api.sdk.entity.DrawRecord;
import com.lbank.java.api.sdk.entity.TicketMessage;
import com.lbank.java.api.sdk.entity.Trades;
import com.lbank.java.api.sdk.service.impl.LBankJavaApiSdkServiceImpl;

public class LbankJavaApiSdkTest {

	public static void main(String[] args) throws Exception {
		String apiKey = "4fe12d15-2050-46b3-8f82-c0c3347872c8";
		String SecretKey = "B31B4151214A264E4CB8AA37F3EA55B6";
		LBankJavaApiSdkServiceImpl LBankJavaApiSdkServiceImpl = new LBankJavaApiSdkServiceImpl(apiKey,SecretKey);
		Map<String, Object> userInfo = LBankJavaApiSdkServiceImpl.getUserInfo();
		System.out.println(userInfo);
		
		Map<String, String> createOrder = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "buy", "0.011", "100");
		System.out.println(createOrder);
		
		Map<String, String> createOrder2 = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "sell", "0.011", "100");
		System.out.println(createOrder2);
		
		Map<String, String> cancelOrder = LBankJavaApiSdkServiceImpl.cancelOrder("eth_btc", "2fa7d27f-8727-47e6-88d4-b7a56a29c764");
		System.out.println(cancelOrder);
		
		Map<String, Object> ordersInfo = LBankJavaApiSdkServiceImpl.getOrdersInfo("eth_btc", "de067674-5f8b-456d-a418-f7c62933a56e");
		System.out.println(ordersInfo);
		
		Map<String, Object> ordersInfoHistory = LBankJavaApiSdkServiceImpl.getOrdersInfoHistory("eth_btc","1", "10");
		System.out.println(ordersInfoHistory);
		
		List<Map<String,String>> accuracy = LBankJavaApiSdkServiceImpl.getAccuracy();
		System.out.println(accuracy);
		
		Map<String, Object> ordersInfoNoDeal = LBankJavaApiSdkServiceImpl.getOrdersInfoNoDeal("eth_btc","1", "10");
		System.out.println(ordersInfoNoDeal);
		
		Object ticker = LBankJavaApiSdkServiceImpl.getTicker("eth_btc");
		ObjectMapper m = new ObjectMapper();
		TicketMessage convertValue = m.convertValue(ticker, TicketMessage.class);
		System.out.println(convertValue);
		
		Object tickerList = LBankJavaApiSdkServiceImpl.getTicker("all");
		List<TicketMessage> ls = (List<TicketMessage>) tickerList;
		System.out.println(ls);
		
		List<String> currencyPairs = LBankJavaApiSdkServiceImpl.getCurrencyPairs();
		System.out.println(currencyPairs);
		
		Map<String, Object> depth = LBankJavaApiSdkServiceImpl.getDepth("eth_btc", 10, 1);
		System.out.println(depth);
		Object trades = LBankJavaApiSdkServiceImpl.getTrades("eth_btc", 1, null);
		if(trades instanceof List) {
			System.out.println((List<Trades>)trades);
		}else {
			System.out.println(trades);
		}
		
		Object kline = LBankJavaApiSdkServiceImpl.getKline("eth_btc", 10, "day1", String.valueOf(System.currentTimeMillis()));
		if(kline instanceof String[]) {
			System.out.println((String[])kline);
		}else {
			System.out.println(kline);
		}
		
		Map<String, String> usdToCny = LBankJavaApiSdkServiceImpl.getUsdToCny();
		System.out.println(usdToCny);
		
		List<Map<String,String>> withdrawConfigs = LBankJavaApiSdkServiceImpl.getWithdrawConfigs("eth");
		System.out.println(withdrawConfigs);
		
		Map<String, String> withdraw = LBankJavaApiSdkServiceImpl.getWithdraw("121", "eth", "1", "1", "1", "0,01");
		System.out.println(withdraw);
		
		Map<String, String> withdrawCancel = LBankJavaApiSdkServiceImpl.getWithdrawCancel("89961");
		System.out.println(withdrawCancel);
		
		Map<String, Object> withdraws = LBankJavaApiSdkServiceImpl.getWithdraws("eth", "1", "1", "10");
		Object object = withdraws.get("list");
		if(object instanceof List) {
			List<DrawRecord> list = (List)object;
			System.out.println(list);
		}else {
			System.out.println(withdraws);
		}
	}
}
