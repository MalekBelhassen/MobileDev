package com.example.hotelbooking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    public static Retrofit retrofit;
    public static final String Base_URL="http://192.168.1.17/HotelApp/";
    public static Retrofit getRetrofitInstance(){
        Gson gson=new GsonBuilder().setLenient().create();
        OkHttpClient client=new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES).build();
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Base_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                     .build();
        }
        return retrofit;
    }
}
