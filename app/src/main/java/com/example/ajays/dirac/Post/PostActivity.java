package com.example.ajays.dirac.Post;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajays.dirac.Forum.ForumActivity;
import com.example.ajays.dirac.Forum.ForumAdapter;
import com.example.ajays.dirac.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {
    TextView title_tv;
    TextView description_tv;
    RecyclerView comments_rv;
    EditText comment_et;
    ImageButton send_btn;
    FirebaseDatabase database;
    CommentsAdapter commentsAdapter;
    ArrayList<String> commentList = new ArrayList<String>();
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        title_tv = findViewById(R.id.title_tv);
        description_tv = findViewById(R.id.description_tv);
        comments_rv = findViewById(R.id.comments_rv);
        comment_et = findViewById(R.id.comment_et);
        send_btn = findViewById(R.id.send_btn);

        database = FirebaseDatabase.getInstance();
        sp = this.getSharedPreferences("login", MODE_PRIVATE);

        title_tv.setText(getIntent().getStringExtra("title"));
        description_tv.setText(getIntent().getStringExtra("description"));

        commentList = getIntent().getStringArrayListExtra("comments");
        DatabaseReference data_ref = database.getReference("posts/"+sp.getString("region",null)+"/0/comments/");

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = comment_et.getText().toString();
                if (text.length() > 0) {
                    data_ref.child(Integer.toString(commentList.size())).setValue(text);
                    commentList.add(text);
                    comment_et.getText().clear();
                }
            }
        });

        setAdapter();
    }

    private void setAdapter(){
        comments_rv.setLayoutManager(new LinearLayoutManager(PostActivity.this,LinearLayoutManager.VERTICAL,false));
        comments_rv.setHasFixedSize(true);

        commentsAdapter = new CommentsAdapter(this,commentList);
        comments_rv.setAdapter(commentsAdapter);
    }
}
