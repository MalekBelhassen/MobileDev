package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView email;
    private TextView passwordLogin;
    private Button login;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (TextView) findViewById(R.id.EmailAddress);
        passwordLogin = (TextView) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.Login);
        signIn = (Button) findViewById(R.id.SingIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //conditions en cas où les champs sont vide
               if(email.getText().toString().equals("")){
                   Toast.makeText(MainActivity.this,"Please enter mail adress",Toast.LENGTH_SHORT).show();
               }
               else if(passwordLogin.getText().toString().equals("")){
                   Toast.makeText(MainActivity.this,"Please enter your password",Toast.LENGTH_SHORT).show();
               }
               else {
                   //liaison entre MainActivity et HomeActivity avec passage des données
                   Intent i = new Intent(MainActivity.this, HomeActivity.class);
                   i.putExtra("email", email.getText().toString());
                   i.putExtra("passwordLogin", passwordLogin.getText().toString());
                   startActivity(i);
               }
           }
       });


    }

}

