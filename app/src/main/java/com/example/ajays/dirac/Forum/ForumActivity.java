package com.example.ajays.dirac.Forum;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajays.dirac.Choice.ChoiceModel;
import com.example.ajays.dirac.R;

import java.util.ArrayList;

public class ForumActivity extends Activity {

    TextView forum_main_tv;
    RecyclerView forum_main_rv;
    ArrayList<ForumModel> forum_list = new ArrayList<>();
    ForumAdapter forum_main_rv_adapter;
    private ChoiceModel forumObject;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forum);

        forum_main_tv = findViewById(R.id.forum_main_title);
        forum_main_rv = findViewById(R.id.forum_main_list);

        forumObject = (ChoiceModel)this.getIntent().getSerializableExtra("chatOrForumChosen");

        Toast.makeText(this, forumObject.getChoice_name(), Toast.LENGTH_SHORT).show();

        for(int i=0;i<30;i++){
            if(i==15){ forum_list.add(new ForumModel("This is a very very very very very very very lonooooooooooooooooooooooong post title text" + i,i,3));
                       continue;}
            forum_list.add(new ForumModel("Post Title " + i,i,0));

        }

        forum_main_rv.setLayoutManager(new LinearLayoutManager(ForumActivity.this,LinearLayoutManager.VERTICAL,false));
        forum_main_rv.setHasFixedSize(true);

        forum_main_rv_adapter = new ForumAdapter(this,forum_list);
        forum_main_rv.setAdapter(forum_main_rv_adapter);
/*
        forum_main_rv_adapter.setOnItem_click_listener(new ForumAdapter.Item_click_listener() {
            @Override
            public void onUpvoteClick(int position) {
                int n= (Integer.parseInt(forum_list.get(position).num_upvotes)) ;
                n+=1;
                Toast.makeText(ForumActivity.this, "CLICKED", Toast.LENGTH_LONG).show();
                forum_list.get(position).num_upvotes=Integer.toString(n);
            }

            @Override
            public void onPostClick(int position) {

            }
        });
*/


    }

}
