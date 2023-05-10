package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class personal_Info extends AppCompatActivity {
    Calendar myCalender;
    EditText name,phone;
    EditText NBPerson,CheckIn,CheckOut;
    TextView hotel;
    String EmailAddressSignIn,PasswordSignIn,passwordLogin,email;
    Button Preview;
    Spinner RoomType;
    String hotelName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        name=(EditText)findViewById(R.id.Fullname);
        phone=(EditText)findViewById(R.id.Phone);
        NBPerson=(EditText)findViewById(R.id.PersoNbr);
        Preview=(Button)findViewById(R.id.Preview);
        RoomType=findViewById(R.id.spinnerType);
        hotel=(TextView)findViewById(R.id.hotelName);
        CheckIn=(EditText) findViewById(R.id.CheckIn);
        CheckOut=(EditText)findViewById(R.id.CheckOut);


        Intent i=getIntent();
        EmailAddressSignIn=i.getStringExtra("EmailAddressSignIn");
       PasswordSignIn=i.getStringExtra("PasswordSignIn");
        email= i.getStringExtra("email");
        passwordLogin=i.getStringExtra("passwordLogin");
        hotelName=i.getStringExtra("hotelName");


        myCalender=Calendar.getInstance();

        RoomType.setSelection(1,true);
        hotel.setText(hotelName);

        Preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(personal_Info.this,"Please enter Name",Toast.LENGTH_SHORT).show();
                }
                else if(phone.length()!=8){
                    Toast.makeText(personal_Info.this,"Please enter phone",Toast.LENGTH_SHORT).show();
                }
                else if(NBPerson.getText().toString().equals("") || NBPerson.getText().toString().equals("0")){
                    Toast.makeText(personal_Info.this,"Please enter person nmber of person",Toast.LENGTH_SHORT).show();
                }
                else if(RoomType.getSelectedItem().toString().contains("select")){
                    Toast.makeText(personal_Info.this,"Please enter Room Type",Toast.LENGTH_SHORT).show();
                }
                else if(CheckIn.getText().toString().equals("")){
                    Toast.makeText(personal_Info.this,"Please enter person check in date",Toast.LENGTH_SHORT).show();
                }
                else if(CheckOut.getText().toString().equals("") || CheckOut.getText().toString().equals(CheckIn.getText().toString())){
                    Toast.makeText(personal_Info.this,"Please enter check out date",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent1 = new Intent(personal_Info.this, PreviewActivity.class);
                    intent1.putExtra(" EmailAddressSignIn", EmailAddressSignIn);
                    intent1.putExtra("PasswordSignIn", PasswordSignIn);
                    intent1.putExtra("email", email);
                    intent1.putExtra("passwordLogin", passwordLogin);
                    intent1.putExtra("name", name.getText().toString());
                    intent1.putExtra("phone", phone.getText().toString());
                    intent1.putExtra("NBPerson", NBPerson.getText().toString());
                    intent1.putExtra("RoomType",RoomType.getSelectedItem().toString());
                    intent1.putExtra("CheckIn", CheckIn.getText().toString());
                    intent1.putExtra("CheckOut", CheckOut.getText().toString());
                    intent1.putExtra("hotelName",hotelName);
                    startActivity(intent1);

                }

            }
        });

        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalender.set(Calendar.YEAR,year);
                myCalender.set(Calendar.MONTH, month);
                myCalender.set(Calendar.DAY_OF_MONTH,day);
                updateLabel(myCalender,CheckIn);
            }


        };
        CheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(personal_Info.this,date, myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        DatePickerDialog.OnDateSetListener date2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalender.set(Calendar.YEAR,year);
                myCalender.set(Calendar.MONTH, month);
                myCalender.set(Calendar.DAY_OF_MONTH,day);
                updateLabel(myCalender,CheckOut);
            }


        };
        CheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(personal_Info.this,date2, myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });





    }
    private void updateLabel(Calendar myCalender,EditText editText) {
        String myFormat="MM/dd/yy";
        SimpleDateFormat sdf =new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(myCalender.getTime()));
    }
}