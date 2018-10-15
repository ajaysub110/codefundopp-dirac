package com.example.ajays.dirac.Forum;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.ajays.dirac.R;

public class PostPop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.forum_post_pop_up_window);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.3));



    }



}
