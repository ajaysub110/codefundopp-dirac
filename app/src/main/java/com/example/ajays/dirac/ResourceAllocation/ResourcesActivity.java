package com.example.ajays.dirac.ResourceAllocation;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.ajays.dirac.R;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResourcesActivity extends AppCompatActivity{

    public CombinedChart mChart;
    public Button resource_add_button;
    public Button set_population_button;

    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource_allocation);

        resource_add_button=findViewById(R.id.resources_add_button);
        resource_add_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourcesActivity.this,ResourceAddPop.class));
                mChart.notifyDataSetChanged();
                mChart.invalidate();
            }
        });

        set_population_button=findViewById(R.id.set_population);
        set_population_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourcesActivity.this,PopulationAddPop.class));
                mChart.notifyDataSetChanged();
                mChart.invalidate();

            }
        });


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        mChart = findViewById(R.id.chart);
        mChart.getAxisRight().setDrawGridLines(false);
        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getXAxis().setDrawGridLines(false);








    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.resource_graph_selection, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.food_graph_view:
                food_graph_view();
                return true;
            case R.id.medical_graph_view:
                medical_graph_view();
                return true;

            case R.id.other_graph_view:
                other_graph_view();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void other_graph_view() {


    }

    private void medical_graph_view() {

    }

    private void food_graph_view() {
        ArrayList<BarEntry> entries1= new ArrayList<>();
        ArrayList<Entry> entries2=new ArrayList<>();
        ArrayList<Float> entries1_f=new ArrayList<Float>();
        ArrayList<Float> entries2_f=new ArrayList<Float>();
        ArrayList<String> reg_values=new ArrayList<>();
        XAxis xAxis = mChart.getXAxis();
        FirebaseDatabase.getInstance().getReference().child("resources")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        float i=0.1f;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            if(snapshot.child("food").hasChildren()){
                                reg_values.add(snapshot.getKey().toString());
                                long total_food_value=0;
                                for(DataSnapshot s2 : snapshot.child("food").getChildren()){
                                    total_food_value += (long)s2.getValue();
                                }
                                float pop_value=(long)snapshot.child("population").getValue();
                                entries1_f.add((float)total_food_value);
                                entries2_f.add((float)pop_value);

                                entries1.add(new BarEntry((float) i+0f, (float) total_food_value+0f));
                                i+=0.2;
                            }
                            else{
                                entries1.add(new BarEntry((float)i+0f,0f));
                                i+=0.5;
                            }
                        }

                        i=0.05f;
                        float pop_max = Collections.max(entries2_f);
                        float food_max = Collections.max(entries1_f);
                        for(Float t:entries2_f){
                            entries2.add(new Entry((float)i+0.05f,(t*(food_max/pop_max))));
                            i+=0.2;
                        }

                        BarDataSet set1 = new BarDataSet(entries1, "FoodData");
                        LineDataSet set2= new LineDataSet(entries2,"PopData");
                        set2.setColor(Color.RED);
                        set2.setLineWidth(2.5f);
                        set2.setCircleSize(5f);
                        set2.setFillColor(Color.WHITE);
                        set2.setCircleColor(Color.BLACK);
                        set2.setHighlightEnabled(false);
                        set2.setDrawValues(false);
                        set1.setBarShadowColor(android.R.color.black);


                        BarData data1 = new BarData(set1 );

                        LineData data2 = new LineData(set2);
                        CombinedData data = new CombinedData();
                        data.setData(data1);
                        data.setData(data2);
                        mChart.zoomOut();
                        data1.setBarWidth(0.1f);
                        mChart.setVisibleYRangeMaximum( 500f, YAxis.AxisDependency.LEFT);
                        mChart.setVisibleXRangeMinimum(1.5f);
                        YAxis rightYAxis = mChart.getAxisRight();
                        rightYAxis.setEnabled(false);
                        mChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
                        mChart.getAxisLeft().setStartAtZero(true);
                        mChart.getAxisLeft().setSpaceBottom(0f);

                        xAxis.setAxisMinimum(0f);
                        xAxis.setAxisMaximum(0.5f);
                        xAxis.setEnabled(false);
                        mChart.setScaleEnabled(true);
                        mChart.getDescription().setText("FOOD CHART");
                        mChart.setPinchZoom(true);
                        mChart.setData(data);
                        mChart.notifyDataSetChanged();


                        mChart.invalidate(); // refresh
                        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                            @Override
                            public void onValueSelected(Entry e, Highlight h) {
                                Log.d("Entry selected", e.toString());


                                float x_value=e.getX();
                                x_value= (x_value-0.1f)*(5f);
                                int x_int = (int) x_value;
                                Log.d("x_val",Float.toString(x_value));

                                Log.d("x_int_val",Integer.toString(x_int));
                                Log.d("Region selected",reg_values.get(x_int));
                                Toast.makeText(ResourcesActivity.this, reg_values.get(x_int), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNothingSelected() {

                            }
                        });
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });






    }


}