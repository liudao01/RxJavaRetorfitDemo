package demo.rxjavaretorfitdemo.base;

import android.content.Context;

import demo.rxjavaretorfitdemo.network.ServerException;
import demo.rxjavaretorfitdemo.util.NetworkUtil;
import rx.Subscriber;

/**
 * @author liuml
 * @explain 封装Subscriber
 * @time 2017/3/3 18:05
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {
    protected Context mContext;

    public BaseSubscriber(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (!NetworkUtil.isConnected(mContext)) {
            _onError(ServerException.ERROR_NETWORK,"网络不可用");
        } else if (e instanceof ServerException) {
            _onError(((ServerException) e).getErrorCode(),e.getMessage());
        } else {
            _onError(ServerException.ERROR_OTHER,e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T t);
    protected abstract void _onError(int errorCode,String msg);
}
