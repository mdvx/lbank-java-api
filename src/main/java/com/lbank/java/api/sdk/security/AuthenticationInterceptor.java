package com.lbank.java.api.sdk.security;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import com.lbank.java.api.sdk.util.LBankJavaApiSdkUtil;

import java.io.IOException;
import java.util.Objects;

/**
 * @author chen.li
 */
public class AuthenticationInterceptor implements Interceptor {
    //用户apikey
    private final String apiKey;
    //用户私钥
    private final String secret;

    public AuthenticationInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();
        //参数拦截器只在非get请求中添加
        String method = original.method();
        if (StringUtils.equals("GET", method)) {
            return chain.proceed(original);
        }
        //加密请求参数获取数字签名
        String payload = original.url().query();
        String sign = LBankJavaApiSdkUtil.getSign(payload,apiKey,secret);
        //追加亲求参数
        HttpUrl signedUrl = original.url().newBuilder().addQueryParameter("api_key", apiKey).addQueryParameter("sign", sign).build();
        newRequestBuilder.url(signedUrl);
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, secret);
    }
}