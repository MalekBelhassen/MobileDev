package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    String EmailAddressSignIn,PasswordSignIn,passwordLogin,email;
    Button ibis,movenpick,Dhiafa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ibis=(Button)findViewById(R.id.ibis);
        movenpick=(Button)findViewById(R.id.movenpick);
        Dhiafa=(Button)findViewById(R.id.Dhiafa);

        Intent i=getIntent();
        EmailAddressSignIn=i.getStringExtra("EmailAddressSignIn");
        PasswordSignIn=i.getStringExtra("PasswordSignIn");
        email= i.getStringExtra("email");
        passwordLogin=i.getStringExtra("passwordLogin");

        ibis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,personal_Info.class);
                intent.putExtra(" EmailAddressSignIn", EmailAddressSignIn);
                intent.putExtra("PasswordSignIn",PasswordSignIn);
                intent.putExtra("email",email);
                intent.putExtra("passwordLogin",passwordLogin);
                intent.putExtra("hotelName","IBIS HOTEL");
                startActivity(intent);

            }
        });
        movenpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,personal_Info.class);
                intent.putExtra(" EmailAddressSignIn", EmailAddressSignIn);
                intent.putExtra("PasswordSignIn",PasswordSignIn);
                intent.putExtra("email",email);
                intent.putExtra("passwordLogin",passwordLogin);
                intent.putExtra("hotelName","MOVENPICK HOTEL");
                startActivity(intent);

            }
        });
        Dhiafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,personal_Info.class);
                intent.putExtra(" EmailAddressSignIn", EmailAddressSignIn);
                intent.putExtra("PasswordSignIn",PasswordSignIn);
                intent.putExtra("email",email);
                intent.putExtra("passwordLogin",passwordLogin);
                intent.putExtra("hotelName","BORJ DHIAFA HOTEL");
                startActivity(intent);

            }
        });
    }
}