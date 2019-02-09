package com.example.aammu.databaseexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText loginName,loginPassword;
    Button login;
    TextView registerHere;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginName = findViewById(R.id.id_login_name);
        loginPassword = findViewById(R.id.id_login_password);
        login = findViewById(R.id.id_login);
        registerHere = findViewById(R.id.id_register_here);

        preferences =
                getSharedPreferences("DatabaseExample",0);
        isLoggedIn  =
                preferences.getBoolean("logged",false);

        if(isLoggedIn){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor = preferences.edit();
                    editor.putBoolean("logged",true);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            registerHere.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }
}
