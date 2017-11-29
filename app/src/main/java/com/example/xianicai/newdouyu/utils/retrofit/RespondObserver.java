package com.example.xianicai.newdouyu.utils.retrofit;

import android.util.Log;

import com.example.xianicai.newdouyu.utils.ToastUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by Zhanglibin on 2017/11/16.
 */

public class RespondObserver<T> implements Observer<HttpResult<T>> {
    private static final String TAG = "RespondObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(HttpResult<T> tHttpResult) {
        if (tHttpResult.error == 0) {
            onSuccess(tHttpResult.getData());
        } else {
            ToastUtil.showMessage(tHttpResult.getMessage());
            onFailure();
        }

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            Log.d(TAG, "onError() called with: " + "throwable = [" + e + "], b = [" + e.getMessage() + "]");
        }
        onFailure();
    }

    @Override
    public void onComplete() {
        onFinish();
    }


    public void onSuccess(T result) {
    }

    public void onFailure() {
    }

    public void onFinish() {
    }
}
