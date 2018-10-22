package com.example.ajays.dirac.Post;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ajays.dirac.Forum.ForumActivity;
import com.example.ajays.dirac.Forum.ForumAdapter;
import com.example.ajays.dirac.R;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {
    TextView title_tv;
    TextView description_tv;
    RecyclerView comments_rv;
    EditText comment_et;
    ImageButton send_btn;

    CommentsAdapter commentsAdapter;
    ArrayList<String> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        title_tv = findViewById(R.id.title_tv);
        description_tv = findViewById(R.id.description_tv);
        comments_rv = findViewById(R.id.comments_rv);
        comment_et = findViewById(R.id.comment_et);
        send_btn = findViewById(R.id.send_btn);

        comments_rv.setLayoutManager(new LinearLayoutManager(PostActivity.this,LinearLayoutManager.VERTICAL,false));
        comments_rv.setHasFixedSize(true);

        commentsAdapter = new CommentsAdapter(this,commentList);
        comments_rv.setAdapter(commentsAdapter);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = comment_et.getText().toString();
                if (text.length() > 0) {
                    // TODO: Save comment to firebase
                    comment_et.getText().clear();
                }
            }
        });
    }
}
