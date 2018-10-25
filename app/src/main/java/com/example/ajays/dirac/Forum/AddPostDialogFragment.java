package com.example.ajays.dirac.Forum;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ajays.dirac.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class AddPostDialogFragment extends DialogFragment {
    EditText dialog_title;
    EditText dialog_description;
    FirebaseDatabase database;
    DatabaseReference data_ref;
    Integer post_number;
    String region;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        Bundle bundle = getArguments();

        this.post_number = bundle.getInt("post_number");
        this.region = bundle.getString("region");

        builder.setView(inflater.inflate(R.layout.dialog_add_post, null))
                // Add action buttons
                .setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog_title = getDialog().findViewById(R.id.dialog_title);
                        dialog_description = getDialog().findViewById(R.id.dialog_description);
                        database = FirebaseDatabase.getInstance();
                        ForumModel newPost = new ForumModel(dialog_title.getText().toString(),
                                dialog_description.getText().toString(),0,new ArrayList<String>());
                        data_ref = database.getReference("posts/"+region+'/');
                        data_ref.child(Integer.toString(post_number)).setValue(newPost);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddPostDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
