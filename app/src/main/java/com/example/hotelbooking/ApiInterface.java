package com.example.hotelbooking;

import android.speech.RecognitionService;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @Multipart
    @POST("hotelUsers.php")
     Call<String> postData(
            @Part("hotelName") RequestBody hotelName,
            @Part("name") RequestBody name,
            @Part("email") RequestBody email,
            @Part("phone") RequestBody phone,
            @Part("NBPerson") RequestBody NBPerson,
            @Part("RoomType") RequestBody RoomType,
            @Part("CheckIn") RequestBody CheckIn,
            @Part("CheckOut") RequestBody CheckOut
    );

}
