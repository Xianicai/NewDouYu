package com.example.xianicai.newdouyu.utils.retrofit.factory;

/**
 * Created by Zhanglibin on 2017/11/29.
 */

public class ResultException extends RuntimeException{
    private int errCode;
    private String msg;

    public ResultException(int errCode,String msg){
        super();
        this.errCode = errCode;
        this.msg = msg;
    }


    public int getErrCode() {
        return errCode;
    }

    public String getMsg(){
        return msg;
    }
}
