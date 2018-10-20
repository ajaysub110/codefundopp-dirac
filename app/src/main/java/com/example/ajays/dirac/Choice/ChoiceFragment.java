package com.example.ajays.dirac.Choice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ajays.dirac.Forum.ForumModel;
import com.example.ajays.dirac.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChoiceFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    RecyclerView choices_rv;
    FloatingActionButton add_choice_fab;
    ArrayList<ChoiceModel> choice_list = new ArrayList<>();
    ChoiceAdapter choices_rv_adapter;
    FirebaseDatabase database;
    private int mPage;

    public static ChoiceFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ChoiceFragment fragment = new ChoiceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choice, container, false);

        choices_rv = (RecyclerView) view.findViewById(R.id.choicelist_rv);
        add_choice_fab = (FloatingActionButton) view.findViewById(R.id.add_choice_fab);

        database = FirebaseDatabase.getInstance();
        DatabaseReference data_ref;

        switch (mPage) {
            case 1:
                data_ref = database.getReference("forums/");
                data_ref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        choice_list.add(dataSnapshot.getValue(ChoiceModel.class));
                        setAdapter();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                        choice_list.remove(Integer.parseInt(dataSnapshot.getKey()));
                        setAdapter();
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getContext(), "Read failed", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 2:/*
                data_ref = database.getReference("contacts/");
                data_ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> contacts = dataSnapshot.getChildren();
                        for (DataSnapshot contact: contacts){
                            ChoiceModel cm = contact.getValue(ChoiceModel.class);
                            Log.d("data_read",cm.time_of_last + ": " + cm.text_of_last);
                            choice_list.add(cm);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getActivity(), "Read failed", Toast.LENGTH_LONG).show();
                    }
                });
                */
                break;
        }

        setAdapter();
        return view;
    }

    private void setAdapter(){
        choices_rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,
                false));
        choices_rv.setHasFixedSize(true);

        choices_rv_adapter = new ChoiceAdapter(this.getContext(), choice_list, mPage);
        choices_rv.setAdapter(choices_rv_adapter);
    }
}
