package com.lbank.java.api.sdk.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.lbank.java.api.sdk.service.LBankJavaApiService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * @author chen.li
 */
public class LBankJavaApiSdkServiceImpl {

    private LBankJavaApiService lBankJavaApiService;

    public LBankJavaApiSdkServiceImpl(String apiKey, String secret) {
        lBankJavaApiService = LBankJavaApiSdkServiceGenerator.createService(LBankJavaApiService.class, apiKey, secret);
    }

    /**
     * 获取用户账户资产信息
     *
     * @return
     */
    public Map<String, Object> getUserInfo() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getUserInfo());
    }

    /**
     * 下单
     *
     * @param symbol 交易对
     * @param type   委托买卖类型buy/sell
     * @param price  下单价格
     * @param amount 交易数量
     * @return
     */
    public Map<String, String> createOrder(String symbol, String type, String price, String amount) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(type)) {
            throw new Exception("type参数为空");
        }
        if (StringUtils.isEmpty(price)) {
            throw new Exception("price参数为空");
        }
        if (StringUtils.isEmpty(amount)) {
            throw new Exception("amount参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.createOrder(symbol, type, price, amount));
    }

    /**
     * 撤销订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    public Map<String, String> cancelOrder(String symbol, String order_id) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(order_id)) {
            throw new Exception("order_id参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.cancelOrder(symbol, order_id));
    }

    /**
     * 查询订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    public Map<String, Object> getOrdersInfo(String symbol, String order_id) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(order_id)) {
            throw new Exception("order_id参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrdersInfo(symbol, order_id));
    }

    /**
     * 查询订单历史
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    public Map<String, Object> getOrdersInfoHistory(String symbol, String current_page, String page_length) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(current_page)) {
            throw new Exception("current_page参数为空");
        }
        if (StringUtils.isEmpty(page_length)) {
            throw new Exception("page_length参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrdersInfoHistory(symbol, current_page, page_length));
    }

    /**
     * 获取所有币对的基本信息
     *
     * @return
     */
    public List<Map<String, String>> getAccuracy() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getAccuracy());
    }

    /**
     * 获取用户开放订单
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    public Map<String, Object> getOrdersInfoNoDeal(String symbol, String current_page, String page_length) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(current_page)) {
            throw new Exception("current_page参数为空");
        }
        if (StringUtils.isEmpty(page_length)) {
            throw new Exception("page_length参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrdersInfoNoDeal(symbol, current_page, page_length));
    }

    /**
     * 获取LBank币币行情数据
     *
     * @param symbol 币对
     * @return
     */
    public Object getTicker(String symbol) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getTicker(symbol));
    }

    /**
     * 获取LBank可用交易对接口
     *
     * @return
     */
    public List<String> getCurrencyPairs() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getCurrencyPairs());
    }

    /**
     * 获取LBank市场深度
     *
     * @param symbol 币对
     * @param size   返回的条数(1-60)
     * @param merge  深度: 0,1
     * @return
     */
    public Map<String, Object> getDepth(String symbol, Integer size, Integer merge) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getDepth(symbol, size, merge));
    }

    /**
     * 获取LBank历史交易信息
     *
     * @param symbol 币对
     * @param size   返回的条数(1-600)
     * @param time   返回时间戳之后 size 条数据，为空则返回最新 size 条数据
     * @return
     */
    public Object getTrades(String symbol, Integer size, String time) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getTrades(symbol, size, time));
    }

    /**
     * 获取K线数据
     *
     * @param symbol 币对
     * @param size   返回的条数(1-2880)
     * @param type   minute1：1分钟
     *               minute5：5分钟
     *               minute15：15分钟
     *               minute30：30分钟
     *               hour1：1小时
     *               hour2：2小时
     *               hour4：4小时
     *               hour6：6小时
     *               hour8：8小时
     *               hour12：12小时
     *               day1：1日
     *               week1：1周
     * @param time   时间戳 (为空则返回当前最新 size 条数据,填写则返回时间戳之后的 size 条数据)
     * @return
     */
    public Object getKline(String symbol, Integer size, String type, String time) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (size == null) {
            throw new Exception("size参数为空");
        }
        if (StringUtils.isEmpty(type)) {
            throw new Exception("type参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getKline(symbol, size, type, time));
    }

    
    /**
     * 美元对人民币的比例
     * 
     * @return
     * @throws Exception 
     */
    public Map<String,String> getUsdToCny() throws Exception{
    	return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getUsdToCny());
    }
    
    /**
     * 币种提币参数接口
     * 
     * @param assetCode
     * @return
     * @throws Exception 
     */
    public List<Map<String,String>> getWithdrawConfigs(String assetCode) throws Exception{
    	return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdrawConfigs(assetCode));
    }
    
    /**
     * 提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     * 
     * @param account	提币地址
     * @param assetCode	提币币种
     * @param amount	提币数量（对于neo，必须是整数）
     * @param memo		对于bts、dct可能需要
     * @param mark		用户备注(长度小于255)
     * @param fee		提币手续费（单位：数量）
     * @return
     * @throws Exception 
     */
    public Map<String,String> getWithdraw(@Query("account") String account,@Query("assetCode") String assetCode,@Query("amount") String amount,
    		@Query("memo") String memo,@Query("mark") String mark,@Query("fee") String fee) throws Exception{
    	if(StringUtils.isEmpty(account)) {
    		throw new Exception("account参数为空");
    	}
    	if(StringUtils.isEmpty(assetCode)) {
    		throw new Exception("assetCode参数为空");
    	}
    	if(StringUtils.isEmpty(amount)) {
    		throw new Exception("amount参数为空");
    	}
    	return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdraw(account, assetCode, amount, memo, mark, fee));
    }
    
    /**
     * 撤销提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     * 
     * @param withdrawId	提币记录编号
     * @return
     * @throws Exception 
     */
    public Map<String,String> getWithdrawCancel(String withdrawId) throws Exception{
    	if(StringUtils.isEmpty(withdrawId)) {
    		throw new Exception("withdrawId参数为空");
    	}
    	return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdrawCancel(withdrawId));
    }
    
    /**
     * 提币记录接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     * 
     * @param assetCode	币种编号
     * @param status	提币状态（0：全部，1：申请中，2：已撤销，3：提现失败，4：提现完成）
     * @param pageNo	当前分页页码（默认：1）
     * @param pageSize	每页大小（默认：20，最大100条）
     * @return
     * @throws Exception 
     */
    public Map<String,Object> getWithdraws(String assetCode,String status,String pageNo,String pageSize) throws Exception{
    	if(StringUtils.isEmpty(status)) {
    		throw new Exception("status参数为空");
    	}
    	return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdraws(assetCode, status, pageNo, pageSize));
    }

}
