package com.example.ajays.dirac.Choice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ajays.dirac.Chat.ChatActivity;
import com.example.ajays.dirac.Forum.ForumActivity;
import com.example.ajays.dirac.R;

import java.util.ArrayList;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceViewHolder> {
    private ArrayList<ChoiceModel> choiceModel;
    private Context context;
    private Integer page;

    public ChoiceAdapter(Context context, ArrayList<ChoiceModel> choiceModel,Integer mPage){
        this.choiceModel = choiceModel;
        this.context = context;
        this.page = mPage;
    }

    @Override
    public ChoiceViewHolder onCreateViewHolder(ViewGroup parent, final int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_choice,parent,false);
        ChoiceViewHolder choiceViewHolder = new ChoiceViewHolder(view);
        return choiceViewHolder;
    }

    @Override
    public void onBindViewHolder(ChoiceViewHolder holder, final int position) {
        holder.item_choice_tv1.setText(choiceModel.get(position).getChoice_name());
        holder.item_choice_tv2.setText(choiceModel.get(position).getDescription());

        holder.item_choice_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                switch (page){
                    case 2:
                        intent = new Intent(context,ChatActivity.class);
                        break;
                    case 1:
                        intent = new Intent(context,ForumActivity.class);
                        break;
                }
                intent.putExtra("chatOrForumChosen",choiceModel.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return choiceModel.size();
    }
}
