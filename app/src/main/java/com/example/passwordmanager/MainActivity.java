package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.passwordmanager.data.UserDao;
import com.example.passwordmanager.data.UserDatabase;
import com.example.passwordmanager.model.User;

public class MainActivity extends AppCompatActivity {
    UserDao db;
    UserDatabase database;

    EditText username,password,repassword;
    Button singup,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(this, UserDatabase.class,"user")
                .allowMainThreadQueries()
                .build();

        db = database.getUserDao();

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
        singup=findViewById(R.id.btnsignup);
        signin=findViewById(R.id.btnsignin);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}