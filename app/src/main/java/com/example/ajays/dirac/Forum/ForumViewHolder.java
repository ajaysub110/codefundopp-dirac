package com.example.ajays.dirac.Forum;

import android.support.annotation.NonNull;
import com.example.ajays.dirac.R;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForumViewHolder extends RecyclerView.ViewHolder{
    TextView forum_post_title;
    TextView forum_post_description;
    ImageButton forum_post_upvote;
    TextView forum_post_num_upvotes;
    CardView forum_post_cardview;
    Button forum_post_comments;


    public ForumViewHolder(@NonNull View itemView){
        super(itemView);

        forum_post_title=itemView.findViewById(R.id.post_title);
        forum_post_description =itemView.findViewById(R.id.post_description);
        forum_post_upvote= itemView.findViewById(R.id.upvote_button);
        forum_post_num_upvotes = itemView.findViewById(R.id.num_upvotes);
        forum_post_cardview = itemView.findViewById((R.id.forum_post_cardview));
        forum_post_comments = itemView.findViewById((R.id.comments_button));
    }

}
