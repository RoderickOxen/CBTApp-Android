package com.cbt.cbtapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbt.cbtapp.R;

public class MainFragment2 extends Fragment {
    private View convertView;

    public MainFragment2(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_main_fragment_2, container, false);
        }
        return convertView;
    }
}
