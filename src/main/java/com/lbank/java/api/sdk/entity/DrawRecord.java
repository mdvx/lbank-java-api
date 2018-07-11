package com.lbank.java.api.sdk.entity;

/**
 * 提币结果对象
 * @author chen.li
 *
 */
public class DrawRecord {
	//提币数量
	private String amount;
	//币种编号
	private String assetCode;
	//提币地址
	private String address;
	//提币手续费
	private String fee;
	//提币记录编号
	private String id;
	//提币时间
	private String time;
	//提币hash
	private String txHash;
	//提币状态
	private String status;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAssetCode() {
		return assetCode;
	}
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTxHash() {
		return txHash;
	}
	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DrawRecord [amount=" + amount + ", assetCode=" + assetCode + ", address=" + address + ", fee=" + fee
				+ ", id=" + id + ", time=" + time + ", txHash=" + txHash + ", status=" + status + "]";
	}
	
}
