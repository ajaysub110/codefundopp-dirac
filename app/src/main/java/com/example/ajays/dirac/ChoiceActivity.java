package com.example.ajays.dirac;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.TextView;

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

        choice_activity_rv_adapter = new ChoiceAdapter(choice_list);
        choice_activity_rv.setAdapter(choice_activity_rv_adapter);

    }
}
