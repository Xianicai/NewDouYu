package com.example.xianicai.newdouyu.utils.retrofit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zhanglibin on 2017/11/16.
 *
 */

public class ThreadTransformer<T> implements ObservableTransformer<T, T>{
    private Scheduler mScheduler;

    public ThreadTransformer() {
        this(AndroidSchedulers.mainThread());
    }

    public ThreadTransformer(Scheduler scheduler) {
        this.mScheduler = scheduler;
    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        upstream = upstream.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io());
        if (mScheduler != null) {
            upstream = upstream.observeOn(mScheduler);
        }
        return upstream;
    }

}
