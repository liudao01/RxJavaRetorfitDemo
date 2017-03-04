package demo.rxjavaretorfitdemo.base;

import android.app.Activity;

import rx.Subscription;

/**
 * @author liuml
 * @explain
 * @time 2017/3/3 18:05
 */

public class BaseActivity extends Activity {

    //订阅器
    protected BaseSubscriber subscription1;
    public Subscription subscription;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    //取消订阅
    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
