package com.cbt.cbtapp.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cbt.cbtapp.R;
import com.cbt.cbtapp.models.Candidate;

import java.util.ArrayList;


public class MainFragment1 extends Fragment {

    private ArrayList<Candidate> candidates_talentLeasing;

    //TO DO
    private View convertView;
    private int image = R.drawable.ic_android_black_24dp;


    public MainFragment1(ArrayList<Candidate> list) {
        candidates_talentLeasing = list;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_main_fragment_1, container, false);
            RecyclerView recyclerView = convertView.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            MainFragment1Adapter adapter = new MainFragment1Adapter(getActivity(), candidates_talentLeasing, image);
            recyclerView.setAdapter(adapter);
        }
        return convertView;
    }
}
