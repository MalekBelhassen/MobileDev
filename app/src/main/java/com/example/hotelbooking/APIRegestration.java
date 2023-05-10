package com.example.hotelbooking;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIRegestration {
    @Multipart
    @POST("users.php")
    Call<String> postDataRegester(
            @Part("email") RequestBody email,
            @Part("password") RequestBody password
    );
}
