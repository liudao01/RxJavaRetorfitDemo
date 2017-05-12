// (c)2016 Flipboard Inc, All Rights Reserved.

package demo.rxjavaretorfitdemo.network;


import java.io.IOException;

import demo.rxjavaretorfitdemo.BuildConfig;
import demo.rxjavaretorfitdemo.network.api.ApiService;
import demo.rxjavaretorfitdemo.util.LogUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author liuml.
 * @explain Retorfit API管理器
 * @time 2017/3/2 15:39
 */
public class RetrofitAPIManager {
    private ApiService woNiuApi;

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private Retrofit retrofit;

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RetrofitAPIManager INSTANCE = new RetrofitAPIManager();
    }

    //获取单例
    public static RetrofitAPIManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    ScalarsConverterFactory scalarsConverterFactory = ScalarsConverterFactory.create();

    //构造方法私有
    private RetrofitAPIManager() {
        //构建Retrofit
        retrofit = new Retrofit.Builder()
                //设置OKHttpClient为网络客户端
                .client(genericClient())
                //配置服务器路径
                .baseUrl(HttpUrls.switchs)
                .addConverterFactory(scalarsConverterFactory)//配置转化库 字符串类型 的
//                //配置转化库，默认是Gson(返回参数不规范 要不然可以直接转换成实体类)
//                .addConverterFactory(gsonConverterFactory)
                //配置回调库，采用RxJava
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    //api
    public ApiService getWoNiuApi() {
        //构建Retrofit
        if (woNiuApi == null) {
            woNiuApi = retrofit.create(ApiService.class);
        }
        return woNiuApi;
    }


    public static OkHttpClient genericClient() {


        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (BuildConfig.DEBUG) {
                    LogUtil.d("OkHttpMessage:" + message);//log信息
                }
            }
        });

        loggingInterceptor.setLevel(level);

        //添加请求头
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .addHeader("userData", "json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        };

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(interceptor)
                .build();

        return httpClient;
    }


}
