package demo.rxjavaretorfitdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import demo.rxjavaretorfitdemo.base.BaseActivity;
import demo.rxjavaretorfitdemo.network.DialogSubscriber;
import demo.rxjavaretorfitdemo.network.RetrofitAPIManager;
import demo.rxjavaretorfitdemo.util.SystemUtils;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author liuml.
 * @explain 基本的get post 请求
 * @time 2017/3/4 17:10
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btGet;
    private Button btPost;
    private TextView tvResult;


    private String secret = "56a1c454a9b946e3a70a1069e21d038c";
    private String appid = "38002";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGet = (Button) findViewById(R.id.bt_get);
        btPost = (Button) findViewById(R.id.bt_post);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btPost.setOnClickListener(this);
        btGet.setOnClickListener(this);


    }

    Observer<Object> observer1 = new Observer() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            tvResult.setText("错误 " + e.getMessage());
        }


        @Override
        public void onNext(Object objects) {
            tvResult.setText(objects.toString());
        }
    };


    Observer<Object> observerLogin = new Observer() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            tvResult.setText("错误 " + e.getMessage());
        }


        @Override
        public void onNext(Object objects) {
            tvResult.setText(objects.toString());
        }
    };

    @Override
    public void onClick(View v) {
//        unsubscribe();

        tvResult.setText("加载中");
        switch (v.getId()) {
            case R.id.bt_get://get请求
                get();

                break;
            case R.id.bt_post://post请求
                post();
                break;
        }

    }

    private void post() {
        subscription = RetrofitAPIManager.getInstance().getWoNiuApi()
                .login("8888", "123456", "", "18001184827", "", "99000709771573")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerLogin);
    }

    private void get() {
//        time	String		2015-07-10	否	从这个时间以来最新的笑话.
//        格式：yyyy-MM-dd
//        page	String	1	1	否	第几页。
//        maxResult	String	20	20	否	每页最大记录数。其值为1至50。
        String secret = "56a1c454a9b946e3a70a1069e21d038c";
        String appid = "38002";
        String time = SystemUtils.getTimeDay();
        String page = "1";
        String maxResult = "30";
        subscription = RetrofitAPIManager.getInstance().getWoNiuApi().xiaohua(appid, secret, time, page, maxResult)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DialogSubscriber<String>(this) {//这里必须每次创建新的

                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        tvResult.setText(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        tvResult.setText("错误 " + e.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }
                });
    }


    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
