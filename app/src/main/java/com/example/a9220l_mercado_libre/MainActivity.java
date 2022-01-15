package com.example.a9220l_mercado_libre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.a9220l_mercado_libre.Vista.BuscarFragment;
import com.example.a9220l_mercado_libre.Vista.HomeFragment;
import com.example.a9220l_mercado_libre.Vista.SitiosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView =  findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment= new HomeFragment();
                        break;
                    case R.id.nav_buscador:
                        fragment= new BuscarFragment();
                        break;
                    case R.id.nav_sitios:
                        fragment= new SitiosFragment();
                        break;

                }

              getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,fragment).commit();

                return true;
            }
        });


            navigationView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN)
                        navigationView.setVisibility(View.GONE);
                    return false;
                }
            });

        }


    }
