package com.example.ajays.dirac;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.ajays.dirac.Forum.ForumMain;
import com.example.ajays.dirac.Chat.ChatActivity;

import java.util.ArrayList;

public class ChoiceActivity extends Activity {

    TextView choice_activity_tv;
    RecyclerView choice_activity_rv;
    ArrayList<ChoiceModel> choice_list = new ArrayList<>();
    ChoiceAdapter choice_activity_rv_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        choice_activity_tv = (TextView)findViewById(R.id.activity_choice_title);
        choice_activity_rv = (RecyclerView)findViewById(R.id.activity_choice_list);

        for(int i=1;i<=10;i+=1){
            choice_list.add(new ChoiceModel("Name "+ i,"Time "+i,
                    "Text corresponding to last entry "+i));
        }

        choice_activity_rv.setLayoutManager(new LinearLayoutManager(ChoiceActivity.this, LinearLayoutManager.VERTICAL,
                false));
        choice_activity_rv.setHasFixedSize(true);

        choice_activity_rv_adapter = new ChoiceAdapter(this,choice_list);
        choice_activity_rv.setAdapter(choice_activity_rv_adapter);

        Button tmp =  findViewById(R.id.tmp);

        tmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChoiceActivity.this,ForumMain.class));
            }
        });


    }
}
