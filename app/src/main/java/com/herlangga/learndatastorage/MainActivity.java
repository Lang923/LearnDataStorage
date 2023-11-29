package com.herlangga.learndatastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;
    RadioGroup genderRadioGrup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        genderRadioGrup = findViewById(R.id.genderRadioGrup);
    }
    public void register(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        int selectedGenderId = genderRadioGrup.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
        String gender = selectedGenderRadioButton.getText().toString();

//        Pada SharedPreference berguna untuk melakukan hasil inputan dari user yang menggunakan method putString untuk
//        untuk mengirim hasil inputan
        SharedPreferences sharedPreferences = this.getSharedPreferences("ABC_SHAREDPREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

//      Menyimpan email ke SharedPreferences dengan key "ABC_EMAIL"
        editor.putString("ABC_EMAIL", email);
//      Menyimpan password ke SharedPreferences dengan key "PASSWORD"
        editor.putString("PASSWORD", password);
//      Menyimpan gender ke SharedPreferences dengan key "GENDER"
        editor.putString("GENDER", gender);
//      Menerapkan perubahan ke SharedPreferences
        editor.apply();

//      Gunakan Intent untuk pindah ke activity penerima
        Intent intent = new Intent(this,AccountActivity.class);
        startActivity(intent);
    }
}