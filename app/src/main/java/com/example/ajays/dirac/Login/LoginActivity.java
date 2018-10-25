package com.example.ajays.dirac.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ajays.dirac.MainActivity;
import com.example.ajays.dirac.R;
import com.example.ajays.dirac.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText username_et, password_et, region_et, auth_et;
    Button login_btn;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username_et = findViewById(R.id.username_et);
        password_et = findViewById((R.id.password_et));
        region_et = findViewById((R.id.region_et));
        auth_et = findViewById(R.id.auth_et);
        login_btn = findViewById(R.id.login_btn);
        database = FirebaseDatabase.getInstance().getReference();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username_et.getText().toString();
                String password = password_et.getText().toString();
                String region = region_et.getText().toString();
                String auth = auth_et.getText().toString();

                Integer auth_num=0;
                if (auth.toLowerCase().equals("yes")) {
                    auth_num = 1;
                }
                User newUser = new User(password,region,auth_num);
                database.child("users").child(username).setValue(newUser);
                database.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(!dataSnapshot.child("resources").hasChild(region)){
                            database.child("resources").child(region).push();
                            database.child("resources").child(region).child("food").push();
                            database.child("resources").child(region).child("medical").push();
                            database.child("resources").child(region).child("other_necessities").push();
                            database.child("resources").child(region).child("population").push();
                            database.child("resources").child(region).child("food").setValue(0);
                            database.child("resources").child(region).child("medical").setValue(0);
                            database.child("resources").child(region).child("other_necessities").setValue(0);
                            database.child("resources").child(region).child("population").setValue(0);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                SharedPreferences sp=getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.putString("region",region);
                editor.putInt("auth",auth_num);
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void writeNewUser(String username,String password, String region, String auth){

    }
}
