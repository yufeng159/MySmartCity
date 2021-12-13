package com.example.smartcity.ApiService;

import com.example.smartcity.bean.*;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    public final static String BASE_ULR="http://124.93.196.45:10091/";
    //登录接口

    @POST("/prod-api/api/login")
    @Headers({"Content-Type: application/json"})
    Call<Result> login(@Body Map<String,String> parms);
    //注册接口
    @POST("/prod-api/api/register")
    @Headers({"Content-Type: application/json"})
    Call<Result> register(@Body Map<String,String> parms);
    //获取个人信息
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @GET("/prod-api/api/common/user/getInfo")
    Call<InfoResult> getinfo(@Header("Authorization") String token);
    //修改个人信息
    @PUT("/prod-api/api/common/user")
    @Headers({"Content-Type: application/json"})
    Call<Result> putinfo(@Header("Authorization") String token,@Body Map<String,String> map);
    //修改密码
    @PUT("/prod-api/api/common/user/resetPwd")
    @Headers({"Content-Type: application/json"})
    Call<Result> putPwd(@Header("Authorization") String token,@Body Map<String,String> map);
    //注销
    @POST("/logout")
    Call<InfoResult> logout(@Header("Authorization") String token);
    //首页轮播图
    @GET("/prod-api/api/rotation/list?type=2")
    Call<BannerResult> Banner();
    //全部服务接口
    @GET("/prod-api/api/service/list")
    Call<AllResult> Service();
    //查询房源
    @GET("/prod-api/api/house/housing/list")
    Call<RoomResult> Room();
    //查询房源详情
    @GET("/prod-api/api/house/housing/{id}")
    Call<RoomDetilsResult> RoomDetils(@Path("id") int id);
    //获取当前位置
    @GET("/prod-api/api/common/gps/area")
    Call gps();
    //地铁广告轮播
    @GET("/prod-api/api/metro/rotation/list")
    Call metroRotationList();
    //地铁首页
    @GET("/prod-api/api/metro/list?currentName=建国门")
    Call<MetroListResult> metroList();
    //地铁总览
    @GET("/prod-api/api/metro/city")
    Call<MetroCityResult> metroCity();
    //地铁所有路线
    @GET("/prod-api/api/metro/line/list")
    Call<MetroLineList> metroLineList();
    //查询地铁站信息（标注到站地铁的信息）
    @GET("/prod-api/api/metro/line/{id}")
    Call<MetroDetilsResult> metroDetils(@Path("id") int id);
    //获取工作职位
    @GET ("/prod-api/api/job/post/list")
    Call<JobpostResult> post(@Header("Authorization") String token);

}
