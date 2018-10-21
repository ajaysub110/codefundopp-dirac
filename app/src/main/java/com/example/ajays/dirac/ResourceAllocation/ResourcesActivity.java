package com.example.ajays.dirac.ResourceAllocation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.ajays.dirac.R;

import java.util.ArrayList;


import java.util.ArrayList;
import java.util.List;

public class ResourcesActivity extends AppCompatActivity{

    private BarChart mChart;
    public Button resource_add_button;
    public Button set_population_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource_allocation);
        resource_add_button=findViewById(R.id.resources_add_button);
        resource_add_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourcesActivity.this,ResourceAddPop.class));

            }
        });

        set_population_button=findViewById(R.id.set_population);
        set_population_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourcesActivity.this,PopulationAddPop.class));

            }
        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mChart = findViewById(R.id.chart);
        mChart.getAxisRight().setDrawGridLines(false);
        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getXAxis().setDrawGridLines(false);
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Region A");
        labels.add("Region B");
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));


        BarDataSet set = new BarDataSet(entries, "BarDataSet");

        BarData data = new BarData(set );
        data.setBarWidth(0.9f); // set custom bar width
        mChart.setData(data);
        mChart.setFitBars(true); // make the x-axis fit exactly all bars
        mChart.invalidate(); // refresh



    }








}