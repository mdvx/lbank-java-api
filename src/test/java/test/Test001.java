package test;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbank.java.api.sdk.entity.TicketMessage;
import com.lbank.java.api.sdk.entity.Trades;
import com.lbank.java.api.sdk.service.impl.LBankJavaApiSdkServiceImpl;

public class Test001 {

	public static void main(String[] args) throws Exception {
		String apiKey = "4fe12d15-2050-46b3-8f82-c0c3347872c8";
		String SecretKey = "B31B4151214A264E4CB8AA37F3EA55B6";
		LBankJavaApiSdkServiceImpl LBankJavaApiSdkServiceImpl = new LBankJavaApiSdkServiceImpl(apiKey,SecretKey);
//		Map<String, Object> userInfo = LBankJavaApiSdkServiceImpl.getUserInfo();
//		System.out.println(userInfo);
//		Map<String, String> createOrder = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "buy", "0.011", "100");
//		System.out.println(createOrder);
//		Map<String, String> createOrder2 = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "sell", "0.011", "100");
//		System.out.println(createOrder2);
//		Map<String, String> cancelOrder = LBankJavaApiSdkServiceImpl.cancelOrder("eth_btc", "");
//		System.out.println(cancelOrder);
//		Map<String, Object> ordersInfo = LBankJavaApiSdkServiceImpl.getOrdersInfo("eth_btc", "");
//		System.out.println(ordersInfo);
//		Map<String, Object> ordersInfoHistory = LBankJavaApiSdkServiceImpl.getOrdersInfoHistory("eth_btc","1", "10");
//		System.out.println(ordersInfoHistory);
//		List<Map<String,String>> accuracy = LBankJavaApiSdkServiceImpl.getAccuracy();
//		System.out.println(accuracy);
//		Map<String, Object> ordersInfoNoDeal = LBankJavaApiSdkServiceImpl.getOrdersInfoNoDeal("eth_btc","1", "10");
//		System.out.println(ordersInfoNoDeal);
//		Object ticker = LBankJavaApiSdkServiceImpl.getTicker("eth_btc");
//		ObjectMapper m = new ObjectMapper();
//		TicketMessage convertValue = m.convertValue(ticker, TicketMessage.class);
//		System.out.println(convertValue);
		Object ticker = LBankJavaApiSdkServiceImpl.getTicker("all");
		List<TicketMessage> ls = (List<TicketMessage>) ticker;
		System.out.println(ls);
//		List<String> currencyPairs = LBankJavaApiSdkServiceImpl.getCurrencyPairs();
//		System.out.println(currencyPairs);
//		Map<String, Object> depth = LBankJavaApiSdkServiceImpl.getDepth("eth_btc", 1, 1);
//		System.out.println(depth);
//		List<Trades> trades = LBankJavaApiSdkServiceImpl.getTrades("eth_btc", 1, null);
//		System.out.println(trades);
//		List<String[]> kline = LBankJavaApiSdkServiceImpl.getKline("eth_btc", 1, "hour1", null);
//		System.out.println(kline);
	}
}
