package com.lbank.java.api.sdk.service;

import java.util.List;
import java.util.Map;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author chen.li
 */
public interface LBankJavaApiService {
    /**
     * 获取用户账户资产信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/user_info.do")
    Call<Map<String, Object>> getUserInfo();

    /**
     * 下单
     *
     * @param symbol 交易对
     * @param type   委托买卖类型buy/sell
     * @param price  下单价格
     * @param amount 交易数量
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/create_order.do")
    Call<Map<String, String>> createOrder(@Query("symbol") String symbol, @Query("type") String type, @Query("price") String price, @Query("amount") String amount);

    /**
     * 撤销订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/cancel_order.do")
    Call<Map<String, String>> cancelOrder(@Query("symbol") String symbol, @Query("order_id") String order_id);

    /**
     * 查询订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/orders_info.do")
    Call<Map<String, Object>> getOrdersInfo(@Query("symbol") String symbol, @Query("order_id") String order_id);

    /**
     * 查询订单历史
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/orders_info_history.do")
    Call<Map<String, Object>> getOrdersInfoHistory(@Query("symbol") String symbol, @Query("current_page") String current_page, @Query("page_length") String page_length);

    /**
     * 获取所有币对的基本信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/accuracy.do")
    Call<List<Map<String, String>>> getAccuracy();

    /**
     * 获取用户开放订单
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/orders_info_no_deal.do")
    Call<Map<String, Object>> getOrdersInfoNoDeal(@Query("symbol") String symbol, @Query("current_page") String current_page, @Query("page_length") String page_length);

    /**
     * 获取LBank币币行情数据
     *
     * @param symbol 币对
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/ticker.do")
    Call<Object> getTicker(@Query("symbol") String symbol);

    /**
     * 获取LBank可用交易对接口
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/currencyPairs.do")
    Call<List<String>> getCurrencyPairs();

    /**
     * 获取LBank市场深度
     *
     * @param symbol 币对
     * @param size   返回的条数(1-60)
     * @param merge  深度: 0,1
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/depth.do")
    Call<Map<String, Object>> getDepth(@Query("symbol") String symbol, @Query("size") Integer size, @Query("merge") Integer merge);

    /**
     * 获取LBank历史交易信息
     *
     * @param symbol 币对
     * @param size   返回的条数(1-600)
     * @param time   返回时间戳之后 size 条数据，为空则返回最新 size 条数据
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/trades.do")
    Call<Object> getTrades(@Query("symbol") String symbol, @Query("size") Integer size, @Query("time") String time);

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
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/kline.do")
    Call<Object> getKline(@Query("symbol") String symbol, @Query("size") Integer size, @Query("type") String type, @Query("time") String time);
    
    
    /**
     * 美元对人民币的比例
     * 
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/usdToCny.do")
    Call<Map<String,String>> getUsdToCny();
    
    /**
     * 币种提币参数接口
     * 
     * @param assetCode
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v1/withdrawConfigs.do")
    Call<List<Map<String,String>>> getWithdrawConfigs(@Query("assetCode") String assetCode);
    
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
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/withdraw.do")
    Call<Map<String,String>> getWithdraw(@Query("account") String account,@Query("assetCode") String assetCode,@Query("amount") String amount,
    		@Query("memo") String memo,@Query("mark") String mark,@Query("fee") String fee);
    
    /**
     * 撤销提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     * 
     * @param withdrawId	提币记录编号
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/withdrawCancel.do")
    Call<Map<String,String>> getWithdrawCancel(@Query("withdrawId") String withdrawId);
    
    /**
     * 提币记录接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     * 
     * @param assetCode	币种编号
     * @param status	提币状态（0：全部，1：申请中，2：已撤销，3：提现失败，4：提现完成）
     * @param pageNo	当前分页页码（默认：1）
     * @param pageSize	每页大小（默认：20，最大100条）
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v1/withdraws.do")
    Call<Map<String,Object>> getWithdraws(@Query("assetCode") String assetCode,@Query("status") String status,@Query("pageNo") String pageNo,@Query("pageSize") String pageSize);

}
