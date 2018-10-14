package com.example.ajays.dirac;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ChoiceViewHolder extends RecyclerView.ViewHolder{
    TextView item_choice_tv1;
    TextView item_choice_tv2;
    TextView item_choice_tv3;

    public ChoiceViewHolder(@NonNull View itemView) {
        super(itemView);

        item_choice_tv1 = itemView.findViewById(R.id.item_choice_name);
        item_choice_tv2 = itemView.findViewById(R.id.item_choice_time);
        item_choice_tv3 = itemView.findViewById(R.id.item_choice_text);
    }


}
