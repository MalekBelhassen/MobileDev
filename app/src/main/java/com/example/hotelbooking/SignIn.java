package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
EditText EmailAddressSignIn,PasswordSignIn;
Button SignBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EmailAddressSignIn=(EditText) findViewById(R.id.EmailAddressSignIn);
        PasswordSignIn=(EditText) findViewById(R.id.PasswordSignIn);
        SignBtn=(Button) findViewById(R.id.Sign);


   SignBtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if(EmailAddressSignIn.getText().toString().equals("")){
               Toast.makeText(SignIn.this,"Please enter mail adress",Toast.LENGTH_SHORT).show();
           }
           else if(PasswordSignIn.getText().toString().equals("")){
               Toast.makeText(SignIn.this,"Please enter your password",Toast.LENGTH_SHORT).show();
           }
           else {
               Intent i = new Intent(SignIn.this, HomeActivity.class);
               i.putExtra("email", EmailAddressSignIn.getText().toString());
               i.putExtra("passwordLogin", PasswordSignIn.getText().toString());
               startActivity(i);
           }
       }
   });
    }
}