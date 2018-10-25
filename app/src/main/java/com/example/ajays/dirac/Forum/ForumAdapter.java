package com.example.ajays.dirac.Forum;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ajays.dirac.Post.PostActivity;
import com.example.ajays.dirac.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Math.abs;


public class ForumAdapter extends RecyclerView.Adapter<ForumViewHolder>{
    private ArrayList<ForumModel> forumModel;
    Context context;
    FirebaseDatabase database;
    SharedPreferences sp;
    Integer current_upvotes;

    public ForumAdapter(Context context, ArrayList<ForumModel> forumModel) {
        this.forumModel = forumModel;
        this.context = context;
        current_upvotes=0;
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
        holder.forum_post_description.setText(forumModel.get(i).getPost_description());
        holder.forum_post_num_upvotes.setText(forumModel.get(i).getNum_upvotes().toString());

        database = FirebaseDatabase.getInstance();
        sp = sp=context.getSharedPreferences("login", MODE_PRIVATE);

        holder.forum_post_upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference data_ref = database.getReference("posts/"+ sp.getString("region",null)+'/');

                data_ref.child(Integer.toString(i)).child("num_upvotes").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.d("data_read",dataSnapshot.getValue().toString());
                        current_upvotes = Integer.parseInt(dataSnapshot.getValue().toString());
                        Log.d("data_read",current_upvotes.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                if (current_upvotes==0){
                    data_ref.child(Integer.toString(i)).child("num_upvotes").setValue(current_upvotes+1);
                    current_upvotes = 1;
                    holder.forum_post_upvote.setColorFilter(context.getResources().getColor(R.color.colorSecondary));
                }
                else{
                    data_ref.child(Integer.toString(i)).child("num_upvotes").setValue(current_upvotes-1);
                    holder.forum_post_upvote.setColorFilter(context.getResources().getColor(R.color.black));
                    current_upvotes = 0;
                }
                holder.forum_post_num_upvotes.setText(current_upvotes.toString());
            }
        });

        holder.forum_post_comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PostActivity.class);
                ForumModel singlePost = forumModel.get(i);
                intent.putExtra("title",singlePost.post_title);
                intent.putExtra("description",singlePost.post_description);
                intent.putExtra("num_upvotes",singlePost.num_upvotes);
                intent.putExtra("comments",singlePost.getComments());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return forumModel.size();
    }
}
