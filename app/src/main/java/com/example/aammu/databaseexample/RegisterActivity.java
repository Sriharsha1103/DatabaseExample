package com.example.aammu.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText registerName,registerPassword,
            registerEmailId;
    Button register;
    DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerName = findViewById(R.id.id_register_name);
        registerPassword = findViewById(R.id.id_register_password);
        registerEmailId = findViewById(R.id.id_register_email);
        register = findViewById(R.id.id_register);

        helper = new DbHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setPersonName(registerName.getText().toString());
                person.setPersonContact(registerPassword.getText().toString());;
                person.setPersonEmail(registerEmailId.getText().toString());
                helper.storePerson(person);
                Toast.makeText(
                        RegisterActivity.this,
                        "Data is stored",
                        Toast.LENGTH_SHORT)
                        .show();
                Intent i = new Intent(
                        getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });




    }
}
