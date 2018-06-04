package com.lbank.java.api.sdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author chen.li
 *
 */
public class LBankJavaApiSdkUtil {
	/**
	 * 根据参数生成32位的MD5加密码
	 * 
	 * @param str
	 * @param apiKey
	 * @param secretKey
	 * @return
	 */
	public static String getMD5(String str, String apiKey, String secretKey) {
		StringBuffer buffer = new StringBuffer();
		if (StringUtils.isNoneBlank(str)) {
			str = str + "&api_key=" +apiKey;
			String[] split = StringUtils.split(str, "&");
			Arrays.sort(split);
			for(int i =0;i<split.length;i++) {
				buffer.append(split[i]).append("&");
			}
		} else {
			buffer.append("api_key=").append(apiKey).append("&");
		}
		buffer.append("secret_key=").append(secretKey);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(buffer.toString().getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			String re_md5 = buf.toString();
			return re_md5.toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
