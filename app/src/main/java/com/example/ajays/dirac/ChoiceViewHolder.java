package com.example.ajays.dirac;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ajays.dirac.Chat.ChatActivity;

public class ChoiceViewHolder extends RecyclerView.ViewHolder{
    TextView item_choice_tv1;
    TextView item_choice_tv2;
    TextView item_choice_tv3;
    LinearLayout item_choice_layout;

    public ChoiceViewHolder(@NonNull final View itemView) {
        super(itemView);

        item_choice_tv1 = itemView.findViewById(R.id.item_choice_name);
        item_choice_tv2 = itemView.findViewById(R.id.item_choice_time);
        item_choice_tv3 = itemView.findViewById(R.id.item_choice_text);
        item_choice_layout = itemView.findViewById(R.id.item_choice_layout);

    }


}
