package com.example.ajays.dirac.Post;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ajays.dirac.R;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
    private ArrayList<String> commentList;
    Context context;

    public class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView comment_tv;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            comment_tv = itemView.findViewById(R.id.comment_tv);
        }
    }

    public CommentsAdapter(Context context, ArrayList<String> commentList) {
        this.commentList = commentList;
        this.context = context;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_comment,parent,false);
        CommentViewHolder commentViewHolder = new CommentViewHolder(view);
        return commentViewHolder;
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int i) {
        holder.comment_tv.setText(commentList.get(i));
    }

    @Override
    public int getItemCount() {
        try {
            return commentList.size();
        }catch (NullPointerException e){
            return 0;
        }
    }
}
