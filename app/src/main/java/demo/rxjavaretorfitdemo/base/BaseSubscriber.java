package demo.rxjavaretorfitdemo.base;

import android.content.Context;
import android.text.TextUtils;

import java.net.SocketTimeoutException;

import demo.rxjavaretorfitdemo.App;
import demo.rxjavaretorfitdemo.util.LogUtil;
import demo.rxjavaretorfitdemo.util.NetworkUtil;
import demo.rxjavaretorfitdemo.util.SystemUtils;
import demo.rxjavaretorfitdemo.util.ToastUtils;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;


/**
 * @author liuml
 * @explain 封装基础Subscriber
 * @time 2017/3/3 18:05
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {
    protected Context mContext;

    public BaseSubscriber(Context mContext) {
        this.mContext = mContext;
    }

    public BaseSubscriber() {
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onStart() {
        super.onStart();
        //请求开始之前，检查是否有网络.
        if (!NetworkUtil.isConnected(App.getContext())) {
            ToastUtils.showShort("当前网络不可用，请检查网络情况");
            // 一定好主动调用下面这一句
            onCompleted();
            return;
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException e1 = (HttpException) e;
            LogUtil.d(" e1.message() = " + e1.message());
            int code = e1.code();
            onFail(code, ((HttpException) e).message());
        }else  if(e instanceof SocketTimeoutException){
            ToastUtils.showShort("请求超时");
        }
        onCompleted();
    }

    @Override
    public void onNext(T t) {

    }


    public static void onFail(int state, String message) {

        if (!SystemUtils.isNetworkAvailable(App.getContext())) {
            ToastUtils.showShort("网络错误，请检查网络后重试");
        } else if (!TextUtils.isEmpty(message)) {
            if (message.contains("timed out")) {
                ToastUtils.showShort("请求超时");
            } else if (state == 500 || state == 502) {
                ToastUtils.showShort("服务异常,请稍后重试");
            } else if (message.contains("refused")) {
                ToastUtils.showShort("服务请求超时，请稍后重试");
            } else if (state == 0) {
                ToastUtils.showShort("数据异常,请稍后重试");
            } else if (state == 404) {
                ToastUtils.showShort("服务不存在,请稍后重试");
            } else if (state == 403) {
                ToastUtils.showShort("服务资源不可用,请稍后重试");
            } else
                ToastUtils.showShort(message);
        }
    }

//    public abstract void onError(ExceptionHandle.ResponeThrowable e);
}

