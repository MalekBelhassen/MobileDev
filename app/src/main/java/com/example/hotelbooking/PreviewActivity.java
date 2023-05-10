package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreviewActivity extends AppCompatActivity {
   TextView affichage;
    Button submit;
    String name,phone;
    String NBPerson,RoomType,CheckIn,CheckOut,email,hotelName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        affichage=(TextView) findViewById(R.id.affichage);
        submit=(Button)findViewById(R.id.submit);

        Intent i=getIntent();
        email=i.getStringExtra("email");
        CheckIn=i.getStringExtra("CheckIn");
        CheckOut=i.getStringExtra("CheckOut");
        name=i.getStringExtra("name");
        phone=i.getStringExtra("phone");
        NBPerson=i.getStringExtra("NBPerson");
        RoomType=i.getStringExtra("RoomType");
        hotelName=i.getStringExtra("hotelName");

        affichage.setText(
                "hotelName: "+hotelName+
                        "\nName: "+name+
                        "\nMail Adress: "+email+
                        "\nPhone Number: "+phone+
                        "\nNumber of persons: "+NBPerson+
                        "\nNumber Of rooms: "+RoomType+
                        "\nCheck In Date: "+ CheckIn+
                        "\nCheck Out Date: "+CheckOut
        );

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
            }
        });

    }
    public void postData(){
                ApiInterface apiInterface=RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);
                Log.d("PreviewActivity", "hotelName:"+hotelName+",postData called with name: " + name + ", email: " + email + ", phone: " + phone + ", NBPerson: " + NBPerson + ", RoomType: " + RoomType + ", CheckIn: " + CheckIn + ", CheckOut: " + CheckOut);
                Call<String>call=apiInterface.postData(
                        getPart(hotelName),
                        getPart(name),
                        getPart(email),
                        getPart(phone),
                        getPart(NBPerson),
                        getPart(RoomType),
                        getPart(CheckIn),
                        getPart(CheckOut));

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful())
                        {if(response.body().equals("Regestration Already exist"))

                            Toast.makeText(PreviewActivity.this,"Regestration Already exist",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(PreviewActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PreviewActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(PreviewActivity.this,  t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
        });


    }

   /* public void postData(){
        ApiInterface apiInterface=RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<String>call=apiInterface.postData(
                getPart(name),
                getPart(email),
                getPart(phone),
                getPart(NBPerson),
                getPart(RoomType),
                getPart(CheckIn),
                getPart(CheckOut));

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body()!=null){
                    Toast.makeText(PreviewActivity.this,"Success",Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(PreviewActivity.this,"error",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            Toast.makeText(PreviewActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }*/

    private RequestBody getPart(String name){
        if(name==null){
            return RequestBody.create(MediaType.parse("text/plain"),"");
        }
        else{
            return RequestBody.create(MediaType.parse("text/plain"),name);
        }
    }

}