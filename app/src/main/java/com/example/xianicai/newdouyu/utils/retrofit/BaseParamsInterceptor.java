package com.example.xianicai.newdouyu.utils.retrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Zhanglibin on 2017/11/28.
 * 添加消息头和公用参数
 */

public class BaseParamsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        // 新的请求,添加参数
        Request addParam = addParam(oldRequest);
        return chain.proceed(addParam);
    }

    /**
     * 添加公共参数
     *
     * @param oldRequest
     * @return
     */
    private Request addParam(Request oldRequest) {

        HttpUrl.Builder builder = oldRequest.url()
                .newBuilder()
                .setEncodedQueryParameter("client_sys", "android")
                .setEncodedQueryParameter("aid", "android1")
                .setEncodedQueryParameter("time", System.currentTimeMillis() + "")
                .setEncodedQueryParameter("version", "2.421");

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(builder.build())
                .build();

        return newRequest;
    }
}
