package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.passwordmanager.data.UserDao;

public class MainActivity extends AppCompatActivity {
    UserDao db;
    //UserDatabase database;

    EditText username,password,repassword;
    Button singup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*database = Room.databaseBuilder(this, UserDatabase.class,"user")
                .allowMainThreadQueries()
                .build();

        db = database.getUserDao();*/

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
        singup=findViewById(R.id.btnsignup);
        signin=findViewById(R.id.btnsignin);
        DB=new DBHelper(this);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(MainActivity.this, "Plz enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)){
                        Boolean checkuser=DB.checkusername(user);
                        if (checkuser = false){
                            Boolean insert = DB.insetData(user,pass);
                            if (insert==true){
                                Toast.makeText(MainActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User already exists! plz sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "password not matching!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });
    }
}