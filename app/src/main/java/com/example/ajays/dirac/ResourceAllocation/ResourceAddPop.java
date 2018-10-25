package com.example.ajays.dirac.ResourceAllocation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import java.lang.Number;
import java.lang.Integer;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ajays.dirac.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.ajays.dirac.R;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ResourceAddPop extends Activity {
    DatabaseReference database;
    DatabaseReference regional_resource_data;
    Button submit;
    TextView tiertext;
    EditText tier;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.resource_add_pop_up_window);

        SharedPreferences sp=this.getSharedPreferences("login", MODE_PRIVATE);
        database = FirebaseDatabase.getInstance().getReference();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width=dm.widthPixels;
        int height=dm.heightPixels;
        ArrayList<String> resource_types = new ArrayList<>();

        getWindow().setLayout((int)(width*0.8),(int)(height*0.55));

        Spinner resource_drop_down = (Spinner) findViewById(R.id.resource_drop_down);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.resource_types, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tier=findViewById(R.id.resource_tier);
        tiertext=findViewById(R.id.tier_text);
        resource_drop_down.setAdapter(adapter);
        resource_drop_down.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Medical") || selectedItem.equals("Other Necessities")){
                    tier.setVisibility(View.VISIBLE);
                    tiertext.setVisibility(View.VISIBLE);
                }
                else{
                    tier.setVisibility(View.INVISIBLE);
                    tiertext.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tier.setVisibility(View.INVISIBLE);
                tiertext.setVisibility(View.INVISIBLE);
            }
        });

        submit = findViewById(R.id.resource_submit_button);
        submit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                String resource_type = resource_drop_down.getSelectedItem().toString();
                if(resource_type.equals("Food")) {
                    EditText resource_name = findViewById(R.id.resource_name);
                    String res_name = resource_name.getText().toString();
                    EditText resource_quantity = findViewById(R.id.resource_quantity);
                    int quantity = Integer.parseInt(resource_quantity.getText().toString());
                    regional_resource_data = database.child("resources").child(sp.getString("region", null)).child("food");
                    regional_resource_data.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.hasChild(res_name)) {

                                int q = ((int) ((long) dataSnapshot.child(res_name).getValue()));
                                q += quantity;
                                regional_resource_data.child(res_name).setValue(q);
                            } else {
                                database.child("resources").child(sp.getString("region", null)).child("food").child(res_name).push();
                                database.child("resources").child(sp.getString("region", null)).child("food").child(res_name).setValue(quantity);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

                else{
                    EditText resource_name= findViewById(R.id.resource_name);
                    String res_name=resource_name.getText().toString();
                    EditText resource_quantity=findViewById(R.id.resource_quantity);
                    int quantity = Integer.parseInt(resource_quantity.getText().toString());
                    EditText tier_level=findViewById(R.id.resource_tier);
                    int tier=Integer.parseInt(tier_level.getText().toString());
                    if(resource_type.equals("Medical")){resource_type="medical";}
                    else{resource_type="other_necessities";} //mistake in naming things in the database, too late to change
                    regional_resource_data=database.child("resources").child(sp.getString("region",null)).child(resource_type);
                    regional_resource_data.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.hasChild(res_name)){
                                regional_resource_data.child(res_name).child("tier"). setValue(tier);
                                int q= ((int)((long)dataSnapshot.child(res_name).child("quantity").getValue()));
                                q+=quantity;
                                regional_resource_data.child(res_name).child("quantity").setValue(q);
                            }
                            else{
                                regional_resource_data.child(res_name).push();
                                regional_resource_data.child(res_name).child("tier").push();
                                regional_resource_data.child(res_name).child("quantity").push();
                                regional_resource_data.child(res_name).child("tier"). setValue(tier);
                                regional_resource_data.child(res_name).child("quantity").setValue(quantity);
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });



                }
                finish();

            }
        });

    }



}
