package com.example.ajays.dirac.ResourceAllocation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Spinner;
import com.example.ajays.dirac.R;

import com.example.ajays.dirac.R;

import java.util.ArrayList;

public class PopulationAddPop extends Activity {
    EditText population;
    Button submit;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.population_add_pop_up_window);
        SharedPreferences sp=this.getSharedPreferences("login", MODE_PRIVATE);
        database = FirebaseDatabase.getInstance().getReference();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        ArrayList<String> resource_types = new ArrayList<>();

        getWindow().setLayout((int)(width*0.8),(int)(height*0.15));

        submit = findViewById(R.id.population_submit_button);
        submit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                population=findViewById(R.id.population_num);
                int population_value=Integer.parseInt(population.getText().toString());
                database.child("resources").child(sp.getString("region",null)).child("population").setValue(population_value);
                finish();

            }
        });

    }



}
