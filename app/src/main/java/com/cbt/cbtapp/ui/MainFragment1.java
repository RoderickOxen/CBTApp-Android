package com.cbt.cbtapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbt.cbtapp.R;

import java.util.ArrayList;


public class MainFragment1 extends Fragment {

    private View convertView;

    private ArrayList<String> restaurants_name = new ArrayList<String>();
    private ArrayList<String> restaurants_id = new ArrayList<String>();

    private int image = R.drawable.ic_android_black_24dp;

    public MainFragment1(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_main_fragment_1, container, false);

            setRestaurants_name(restaurants_name);
            RecyclerView recyclerView = convertView.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            MainFragment1Adapter adapter = new MainFragment1Adapter(getActivity() , restaurants_id , restaurants_name, image);
            recyclerView.setAdapter(adapter);
        }

        return convertView;
    }


    public void setRestaurants_name(ArrayList<String> restaurants_name) {
        restaurants_name.add("aaa");
        restaurants_name.add("bbb");
        restaurants_name.add("ccc");
        restaurants_name.add("ddd");
        restaurants_name.add("eee");
        restaurants_name.add("fff");

    }





}
