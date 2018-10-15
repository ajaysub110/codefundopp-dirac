package com.example.ajays.dirac.Forum;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ajays.dirac.R;

import java.util.ArrayList;

import static java.lang.Math.abs;


public class ForumAdapter extends RecyclerView.Adapter<ForumViewHolder>{
    private ArrayList<ForumModel> forumModel;
    Context context;

    public ForumAdapter(Context context, ArrayList<ForumModel> forumModel) {
        this.forumModel = forumModel;
        this.context = context;
    }

    @Override
    public ForumViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_forum_post,parent,false);
        ForumViewHolder forumViewHolder = new ForumViewHolder(view);
        return forumViewHolder;
    }

    @Override
    public void onBindViewHolder(ForumViewHolder holder, int i) {
        holder.forum_post_title.setText(forumModel.get(i).getPost_title());
        holder.forum_post_num_replies.setText(forumModel.get(i).getNum_replies().toString());
        holder.forum_post_num_upvotes.setText(forumModel.get(i).getNum_upvotes().toString());

        holder.forum_post_upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                forumModel.get(i).num_upvotes = ~(forumModel.get(i).num_upvotes);

                //Server side upvote count to be updated
                notifyDataSetChanged();

            }
        });

        holder.forum_post_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Connects to a specific forum post

            }
        });


    }

    @Override
    public int getItemCount() {
        return forumModel.size();
    }
}
