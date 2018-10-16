package com.example.ajays.dirac.Forum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajays.dirac.Forum.ForumAdapter;
import com.example.ajays.dirac.Forum.ForumModel;
import com.example.ajays.dirac.R;

import java.util.ArrayList;

public class ForumMain extends Activity {

    TextView forum_main_tv;
    RecyclerView forum_main_rv;
    ArrayList<ForumModel> forum_list = new ArrayList<>();
    ForumAdapter forum_main_rv_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.forum_main);


        forum_main_tv = findViewById(R.id.forum_main_title);
        forum_main_rv = findViewById(R.id.forum_main_list);

        for(int i=0;i<30;i++){
            if(i==15){ forum_list.add(new ForumModel("This is a very very very very very very very lonooooooooooooooooooooooong post title text" + i,i,3));
                       continue;}
            forum_list.add(new ForumModel("Post Title " + i,i,0));

        }



        forum_main_rv.setLayoutManager(new LinearLayoutManager(ForumMain.this,LinearLayoutManager.VERTICAL,false));
        forum_main_rv.setHasFixedSize(true);

        forum_main_rv_adapter = new ForumAdapter(this,forum_list);
        forum_main_rv.setAdapter(forum_main_rv_adapter);
/*
        forum_main_rv_adapter.setOnItem_click_listener(new ForumAdapter.Item_click_listener() {
            @Override
            public void onUpvoteClick(int position) {
                int n= (Integer.parseInt(forum_list.get(position).num_upvotes)) ;
                n+=1;
                Toast.makeText(ForumMain.this, "CLICKED", Toast.LENGTH_LONG).show();
                forum_list.get(position).num_upvotes=Integer.toString(n);
            }

            @Override
            public void onPostClick(int position) {

            }
        });
*/


    }

}
