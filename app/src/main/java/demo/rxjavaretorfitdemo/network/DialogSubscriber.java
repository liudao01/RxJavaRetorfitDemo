package demo.rxjavaretorfitdemo.network;

import android.app.ProgressDialog;
import android.content.Context;

import demo.rxjavaretorfitdemo.base.BaseSubscriber;

/**
 * @author liuml
 * @explain  自定义对话框
 * @time 2017/3/4 16:39
 */

public abstract class DialogSubscriber<T> extends BaseSubscriber<T> {

    ProgressDialog loadingDialog;
    private String loadingMsg;

    public DialogSubscriber(Context mContext) {
        super(mContext);
        this.loadingMsg = "加载中...";
    }

    public DialogSubscriber(Context context, String loadingMsg) {
        super(context);
        this.loadingMsg = loadingMsg;
    }



    protected void showDialog() {
        dismissDialog();
        loadingDialog = new ProgressDialog(mContext);
        loadingDialog.show();
    }


    protected void dismissDialog() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.cancel();

    }


    @Override
    public void onStart() {
        super.onStart();
        showDialog();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        loadingDialog.cancel();
    }

    @Override
    public void onCompleted() {
        dismissDialog();
    }
}
