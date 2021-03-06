package com.example.fragmentbottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    // Deklarasi bottom Navigation
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mengambil bottomNavigation dari activity_main.xml Berdasarkan Id bottomNavigation
        bottomNavigation = findViewById(R.id.bottom_navigation);
        // Menjadikan Salah satu fragment menjadi fragment default disini saya memilih fragment home sebagai fragment default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        // Aksi yang akan di jalankan jika item di pilih
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Menetapkan nilai awal fragment = null
                Fragment selectedFragment = null;

                // kondisi untuk menampilkan fragment sesuai dengan item yang akan di pilih
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_shop:
                        selectedFragment = new ShopFragment();
                        break;
                    case R.id.nav_setting:
                        selectedFragment = new SettingFragment();
                        break;
                }

                // kode menampilkan fragment yang akan ditampilkan sesuai dengan item yang dipilih
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }
}