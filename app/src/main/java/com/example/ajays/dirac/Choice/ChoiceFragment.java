package com.example.ajays.dirac.Choice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ajays.dirac.R;

import java.util.ArrayList;

public class ChoiceFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    RecyclerView choices_rv;
    ArrayList<ChoiceModel> choice_list = new ArrayList<>();
    ChoiceAdapter choices_rv_adapter;

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

        choices_rv = (RecyclerView)view.findViewById(R.id.choicelist_rv);

        switch (mPage){
            case 1:
                for(int i=1;i<=10;i+=1){
                    choice_list.add(new ChoiceModel("Chat "+ i,"Time "+i,
                            "Text corresponding to last chat "+i));
                }
                break;
            case 2:
                for(int i=1;i<=10;i+=1){
                    choice_list.add(new ChoiceModel("Forum "+ i,"Time "+i,
                            "Text corresponding to last post "+i));
                }
                break;
        }

        choices_rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,
                false));
        choices_rv.setHasFixedSize(true);

        choices_rv_adapter = new ChoiceAdapter(this.getContext(), choice_list,mPage);
        choices_rv.setAdapter(choices_rv_adapter);


        return view;
    }
}
