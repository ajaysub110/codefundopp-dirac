package com.example.ajays.dirac;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ajays.dirac.Choice.ChoiceFragmentPagerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public String username;
    public String region;
    public Integer auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp=this.getSharedPreferences("login", MODE_PRIVATE);

        username=sp.getString("username", null);
        region = sp.getString("region",null);
        auth = sp.getInt("auth",0);

        //Toast.makeText(this, username+' '+region+' '+auth, Toast.LENGTH_SHORT).show();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ChoiceFragmentPagerAdapter(getSupportFragmentManager(),MainActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
