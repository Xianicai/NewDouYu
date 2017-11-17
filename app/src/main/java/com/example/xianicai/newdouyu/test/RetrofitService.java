package com.example.xianicai.newdouyu.test;

import com.example.xianicai.newdouyu.utils.retrofit.HttpResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Zhanglibin on 2017/11/15.
 */

public interface RetrofitService {
    /**
     * 获取快递信息
     * Rx方式
     *
     * @param type   快递类型
     * @param postid 快递单号
     * @return Observable<PostInfo>
     */
    @GET("query")
    Observable<HttpResult<List<PostInfo.DataBean>>> getPostInfoRx(@Query("type") String type, @Query("postid") String postid);
}
