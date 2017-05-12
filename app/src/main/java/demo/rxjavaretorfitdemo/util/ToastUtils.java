package demo.rxjavaretorfitdemo.util;

import android.view.Gravity;
import android.widget.Toast;

import demo.rxjavaretorfitdemo.App;


/**
 * Created by tz on 2015/10/9.
 */
public class ToastUtils {


    public static void showShort(String str){
        Toast.makeText(App.getInstance(),str, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String str){
        Toast.makeText(App.getInstance(),str, Toast.LENGTH_LONG).show();
    }

    /**
     * toast居中显示
     *
     * @param      */
    public static void showCenter(String str) {
        try {
            Toast toast = Toast.makeText(App.getInstance(), str, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
