package com.example.tecktrove.view.HomeScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tecktrove.R;

public class HomeScreenActivity extends AppCompatActivity implements HomeScreenView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_screen);

        HomeScreenPresenter presenter = new HomeScreenPresenter(this);
    }
}