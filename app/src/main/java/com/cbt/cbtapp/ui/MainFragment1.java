package com.cbt.cbtapp.ui;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cbt.cbtapp.R;
import com.cbt.cbtapp.models.Candidate;

import java.util.ArrayList;


public class MainFragment1 extends Fragment {

    private View convertView;
    private ArrayList<Candidate> candidates_talentLeasing;

    public MainFragment1(ArrayList<Candidate> list) {
        candidates_talentLeasing = list;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_main_fragment_1, container, false);
            RecyclerView recyclerView = convertView.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            MainFragmentAdapter adapter = new MainFragmentAdapter(getActivity(), candidates_talentLeasing);
            recyclerView.setAdapter(adapter);
        }
        return convertView;
    }
}
