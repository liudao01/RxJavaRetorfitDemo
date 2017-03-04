// (c)2016 Flipboard Inc, All Rights Reserved.

package demo.rxjavaretorfitdemo.network.api;

import demo.rxjavaretorfitdemo.network.HttpUrls;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface WoNiuApi {


    @GET(HttpUrls.CITY)
    Observable<Object> city(@Query("city") String city);


    @GET("v1/customor/my/scan/list")
    Observable<Object> list(@Query("id") String id,
                            @Query("page") String page,
                            @Query("page.size") String size);


    @FormUrlEncoded
    @POST("v1/userLogin/newLogin")
    Observable<Object> login(@Field("code") String code,
                             @Field("invitecode") String pwd,
                             @Field("cname") String cname,
                             @Field("tel") String tel,
                             @Field("iscoming") String iscoming,
                             @Field("udid") String udid)
    ;

}
