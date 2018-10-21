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

public class PopulationAddPop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.population_add_pop_up_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;
        ArrayList<String> resource_types = new ArrayList<>();

        getWindow().setLayout((int)(width*0.8),(int)(height*0.3));



    }



}
