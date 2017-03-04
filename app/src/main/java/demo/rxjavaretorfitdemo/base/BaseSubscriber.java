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
//    private BaseActivity context;
//
//
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        if (!NetworkUtil.isConnected(App.getInstance())) {
//
//            Toast.makeText(App.getInstance(), "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
//            // **一定要主动调用下面这一句**
//            onCompleted();
//
//            return;
//        }
//        // 显示进度条
//
//        // showLoadingProgress();
//    }
//
//    @Override
//    public void onCompleted() {
//        //关闭等待进度条
//        //closeLoadingProgress();
//
//    }
//
//    @Override
//    public void onNext(T t) {
//        _onNext(t);
//    }
//
//    public abstract void _onNext(T t);
//
//    public abstract void _onError(String msg);
}
