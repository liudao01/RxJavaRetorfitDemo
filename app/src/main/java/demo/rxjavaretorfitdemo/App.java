// (c)2016 Flipboard Inc, All Rights Reserved.

package demo.rxjavaretorfitdemo;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

    public static synchronized Context getContext() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
