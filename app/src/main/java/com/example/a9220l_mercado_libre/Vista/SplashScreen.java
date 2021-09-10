package com.example.a9220l_mercado_libre.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.a9220l_mercado_libre.MainActivity;
import com.example.a9220l_mercado_libre.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            Intent intent= new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        },3000);

    }
}