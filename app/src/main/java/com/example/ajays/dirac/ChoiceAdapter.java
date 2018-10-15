package com.example.ajays.dirac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ajays.dirac.Chat.ChatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceViewHolder> {
    private ArrayList<ChoiceModel> choiceModel;
    private Context context;

    public ChoiceAdapter(Context context, ArrayList<ChoiceModel> choiceModel){
        this.choiceModel = choiceModel;
        this.context = context;
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
        holder.item_choice_tv2.setText(choiceModel.get(position).getTime_of_last());
        holder.item_choice_tv3.setText(choiceModel.get(position).getText_of_last());

        holder.item_choice_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ChatActivity.class);
                intent.putExtra("contact",choiceModel.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return choiceModel.size();
    }
}
