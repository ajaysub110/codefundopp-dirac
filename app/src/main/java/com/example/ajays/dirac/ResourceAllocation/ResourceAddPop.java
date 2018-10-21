package com.example.ajays.dirac.ResourceAllocation;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.example.ajays.dirac.R;

import com.example.ajays.dirac.R;

import java.util.ArrayList;

public class ResourceAddPop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.resource_add_pop_up_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        ArrayList<String> resource_types = new ArrayList<>();

        getWindow().setLayout((int)(width*0.8),(int)(height*0.55));

        Spinner resource_drop_down = (Spinner) findViewById(R.id.resource_drop_down);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.resource_types, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        resource_drop_down.setAdapter(adapter);

    }



}
