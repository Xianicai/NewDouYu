package com.example.xianicai.newdouyu.utils.retrofit;

/**
 * Created by Zhanglibin on 2017/4/24.
 */

public class HttpResult<T> {

    int error;
    String message;
    T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }


}
