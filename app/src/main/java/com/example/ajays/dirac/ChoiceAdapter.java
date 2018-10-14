package com.example.ajays.dirac;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceViewHolder> {
    private ArrayList<ChoiceModel> choiceModel;

    public ChoiceAdapter(ArrayList<ChoiceModel> choiceModel){
        this.choiceModel = choiceModel;
    }

    @Override
    public ChoiceViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_choice,parent,false);
        ChoiceViewHolder choiceViewHolder = new ChoiceViewHolder(view);
        return choiceViewHolder;
    }

    @Override
    public void onBindViewHolder(ChoiceViewHolder holder, int position) {
        holder.item_choice_tv1.setText(choiceModel.get(position).getChoice_name());
        holder.item_choice_tv2.setText(choiceModel.get(position).getTime_of_last());
        holder.item_choice_tv3.setText(choiceModel.get(position).getText_of_last());
    }

    @Override
    public int getItemCount() {
        return choiceModel.size();
    }
}
