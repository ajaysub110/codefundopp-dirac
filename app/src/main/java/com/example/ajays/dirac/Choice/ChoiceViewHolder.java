package com.example.ajays.dirac.Choice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ajays.dirac.Chat.ChatActivity;
import com.example.ajays.dirac.R;

public class ChoiceViewHolder extends RecyclerView.ViewHolder{
    TextView item_choice_tv1;
    TextView item_choice_tv2;

    LinearLayout item_choice_layout;

    public ChoiceViewHolder(@NonNull final View itemView) {
        super(itemView);

        item_choice_tv1 = itemView.findViewById(R.id.item_choice_name);
        item_choice_tv2 = itemView.findViewById(R.id.item_choice_description);
        item_choice_layout = itemView.findViewById(R.id.item_choice_layout);

    }


}
