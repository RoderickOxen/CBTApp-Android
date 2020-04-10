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

public class MainFragment2 extends Fragment {

    private View convertView;
    private ArrayList<Candidate> candidates_interRecruitment;
    private Bitmap image;

    //TO delete
    private int imagess = R.drawable.ic_android_black_24dp;


    public MainFragment2(ArrayList<Candidate> list, Bitmap img){
        candidates_interRecruitment = list;
        image = img;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_main_fragment_2, container, false);

            RecyclerView recyclerView = convertView.findViewById(R.id.recyclerView2);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            MainFragmentAdapter adapter = new MainFragmentAdapter(getActivity(), candidates_interRecruitment, image);
            recyclerView.setAdapter(adapter);
        }

        return convertView;
    }



}
