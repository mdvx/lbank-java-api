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
		//获取用户账户资产信息测试
		Map<String, Object> userInfo = LBankJavaApiSdkServiceImpl.getUserInfo();
		System.out.println(userInfo);
		//下单测试
		Map<String, String> createOrder = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "buy", "0.011", "100");
		System.out.println(createOrder);
		//下单测试
		Map<String, String> createOrder2 = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "sell", "0.011", "100");
		System.out.println(createOrder2);
		//撤销订单测试
		Map<String, String> cancelOrder = LBankJavaApiSdkServiceImpl.cancelOrder("eth_btc", "2fa7d27f-8727-47e6-88d4-b7a56a29c764");
		System.out.println(cancelOrder);
		//查询订单测试
		Map<String, Object> ordersInfo = LBankJavaApiSdkServiceImpl.getOrdersInfo("eth_btc", "de067674-5f8b-456d-a418-f7c62933a56e");
		System.out.println(ordersInfo);
		//查询订单历史测试
		Map<String, Object> ordersInfoHistory = LBankJavaApiSdkServiceImpl.getOrdersInfoHistory("eth_btc","1", "10");
		System.out.println(ordersInfoHistory);
		//获取所有币对的基本信息测试
		List<Map<String,String>> accuracy = LBankJavaApiSdkServiceImpl.getAccuracy();
		System.out.println(accuracy);
		//获取用户开放订单测试
		Map<String, Object> ordersInfoNoDeal = LBankJavaApiSdkServiceImpl.getOrdersInfoNoDeal("eth_btc","1", "10");
		System.out.println(ordersInfoNoDeal);
		//获取LBank币币行情数据测试
		Object ticker = LBankJavaApiSdkServiceImpl.getTicker("eth_btc");
		ObjectMapper m = new ObjectMapper();
		TicketMessage convertValue = m.convertValue(ticker, TicketMessage.class);
		System.out.println(convertValue);
		//获取LBank行情数据测试
		Object tickerList = LBankJavaApiSdkServiceImpl.getTicker("all");
		List<TicketMessage> ls = (List<TicketMessage>) tickerList;
		System.out.println(ls);
		//获取LBank可用交易对接口测试
		List<String> currencyPairs = LBankJavaApiSdkServiceImpl.getCurrencyPairs();
		System.out.println(currencyPairs);
		//获取LBank市场深度测试
		Map<String, Object> depth = LBankJavaApiSdkServiceImpl.getDepth("eth_btc", 10, 1);
		System.out.println(depth);
		Object trades = LBankJavaApiSdkServiceImpl.getTrades("eth_btc", 1, null);
		if(trades instanceof List) {
			System.out.println((List<Trades>)trades);
		}else {
			System.out.println(trades);
		}
		//获取K线数据测试
		Object kline = LBankJavaApiSdkServiceImpl.getKline("eth_btc", 10, "day1", String.valueOf(System.currentTimeMillis()));
		if(kline instanceof String[]) {
			System.out.println((String[])kline);
		}else {
			System.out.println(kline);
		}
		//美元对人民币的比例测试
		Map<String, String> usdToCny = LBankJavaApiSdkServiceImpl.getUsdToCny();
		System.out.println(usdToCny);
		//币种提币参数接口测试
		List<Map<String,String>> withdrawConfigs = LBankJavaApiSdkServiceImpl.getWithdrawConfigs("eth");
		System.out.println(withdrawConfigs);
		//提币接口测试
		Map<String, String> withdraw = LBankJavaApiSdkServiceImpl.getWithdraw("121", "eth", "1", "1", "1", "0,01");
		System.out.println(withdraw);
		//撤销提币接口测试
		Map<String, String> withdrawCancel = LBankJavaApiSdkServiceImpl.getWithdrawCancel("89961");
		System.out.println(withdrawCancel);
		//提币记录接口测试
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
