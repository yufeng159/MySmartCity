package com.example.smartcity.ApiService;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static <T> T getService(Class<T> tClass){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(ApiService.BASE_ULR)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
