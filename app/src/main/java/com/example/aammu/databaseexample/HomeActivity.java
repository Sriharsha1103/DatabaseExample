package com.example.aammu.databaseexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView homeName;
    Button redirect;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeName = findViewById(R.id.id_home_name);
        redirect = findViewById(R.id.id_home_logout);

        preferences =
                getSharedPreferences("DatabaseExample",0);
        editor = preferences.edit();

        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("logged",false);
                editor.apply();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
}
