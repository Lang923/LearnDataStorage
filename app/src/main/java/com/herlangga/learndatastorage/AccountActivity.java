package com.herlangga.learndatastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {
//    Deklarasikan Methodnya
    TextView emailTextView;
    TextView passwordTextView;
    TextView genderTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
//        Pada bagian onCreate tambahkan beberapa kode findView untuk membaca method yang dibuat
        emailTextView = findViewById(R.id.emailTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        genderTextview = findViewById(R.id.genderTextView);

//        Pada SharedPreference berguna untuk melakukan hasil inputan dari user yang menggunakan method getString untuk
//        untuk menerima hasil inputan
        SharedPreferences sharedPreferences = this.getSharedPreferences("ABC_SHAREDPREF", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("ABC_EMAIL", "");
        String password = sharedPreferences.getString("PASSWORD", "");
        String gender = sharedPreferences.getString("GENDER", "");

//
        emailTextView.setText(email);
        passwordTextView.setText(password);
        genderTextview.setText(gender);
    }
}