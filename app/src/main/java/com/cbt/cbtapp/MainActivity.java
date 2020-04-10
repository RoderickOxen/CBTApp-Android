package com.cbt.cbtapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cbt.cbtapp.ui.FragmentsAdapter;
import com.cbt.cbtapp.ui.HomeActivity;
import com.cbt.cbtapp.ui.MainFragment1;
import com.cbt.cbtapp.ui.MainFragment2;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ArrayList> list_of_candidates_talentLeasing = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> list_of_candidates_internationalRecruitment = new ArrayList<ArrayList>();
    private ArrayList<String> candidate = new ArrayList<String>();

    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference talentLeasingRef = rootRef.child("Tabela-1").child("TalentLeasing");
    private DatabaseReference internationalRecRef = rootRef.child("Tabela-2").child("InternationalRecruitment");

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FragmentsAdapter viewPagerAdapter;
    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> fragmentTitles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //isto vai buscar os talentLeasing e quando acabar vai buscar os internationalRec
        //getCandidatesTalentLeasing(talentLeasingRef);

        tabLayout = findViewById(R.id.BottomTab);
        viewPager = findViewById(R.id.ViewPager);

        setFragmentArrayList();
        setFragmentTitles();
        viewPagerTabLayout();

    }

    private void getCandidatesTalentLeasing(DatabaseReference talentLeasingRef) {
        talentLeasingRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    candidate.clear();

                    candidate.add(ds.getKey());
                    candidate.add(ds.child("AcademicBackground").getValue().toString());
                    candidate.add(ds.child("Keywords").getValue().toString());
                    candidate.add(ds.child("Motivation to work abroad").getValue().toString());
                    candidate.add(ds.child("Relevant Industries").getValue().toString());
                    candidate.add(ds.child("Residence").getValue().toString());
                    candidate.add(ds.child("Salary Expectation").getValue().toString());
                    candidate.add(ds.child("YearsOfExperience").getValue().toString());

                    list_of_candidates_talentLeasing.add(candidate);

                    //Logs
                    Log.w("ID", String.valueOf(ds.getKey()));
                    Log.w("AcademicBackground", String.valueOf(ds.child("AcademicBackground").getValue()));
                    Log.w("Keywords", String.valueOf(ds.child("Keywords").getValue()));
                    Log.w("Motivation", String.valueOf(ds.child("Motivation to work abroad").getValue()));
                    Log.w("Relevant", String.valueOf(ds.child("Relevant Industries").getValue()));
                    Log.w("Residence", String.valueOf(ds.child("Residence").getValue()));
                    Log.w("Salary", String.valueOf(ds.child("Salary Expectation").getValue()));
                    Log.w("YearsOfExperience", String.valueOf(ds.child("YearsOfExperience").getValue()));

                }
                getCandidatesInternationalRecruitment(internationalRecRef);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }

    private void getCandidatesInternationalRecruitment(DatabaseReference internationalRec) {
        internationalRec.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    candidate.clear();

                    candidate.add(ds.getKey());
                    candidate.add(ds.child("AcademicBackground").getValue().toString());
                    candidate.add(ds.child("Keywords").getValue().toString());
                    candidate.add(ds.child("Motivation to work abroad").getValue().toString());
                    candidate.add(ds.child("Relevant Industries").getValue().toString());
                    candidate.add(ds.child("Residence").getValue().toString());
                    candidate.add(ds.child("Salary Expectation").getValue().toString());
                    candidate.add(ds.child("YearsOfExperience").getValue().toString());

                    list_of_candidates_internationalRecruitment.add(candidate);

                    //Logs
                    Log.w("ID", String.valueOf(ds.getKey()));
                    Log.w("AcademicBackground", String.valueOf(ds.child("AcademicBackground").getValue()));
                    Log.w("Keywords", String.valueOf(ds.child("Keywords").getValue()));
                    Log.w("Motivation", String.valueOf(ds.child("Motivation to work abroad").getValue()));
                    Log.w("Relevant", String.valueOf(ds.child("Relevant Industries").getValue()));
                    Log.w("Residence", String.valueOf(ds.child("Residence").getValue()));
                    Log.w("Salary", String.valueOf(ds.child("Salary Expectation").getValue()));
                    Log.w("YearsOfExperience", String.valueOf(ds.child("YearsOfExperience").getValue()));

                }
                Log.w("size", String.valueOf(list_of_candidates_talentLeasing.size()));
                Log.w("sizeB", String.valueOf(list_of_candidates_internationalRecruitment.size()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }

    private void viewPagerTabLayout(){

        viewPagerAdapter = new FragmentsAdapter(getSupportFragmentManager(), this, fragmentArrayList, fragmentTitles);

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.ic_android_black_24dp);
        }
    }


    private void setFragmentArrayList(){
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new MainFragment1());
        fragmentArrayList.add(new MainFragment2());
    }

    private void setFragmentTitles(){
        fragmentTitles = new ArrayList<>();
        fragmentTitles.add("TL");
        fragmentTitles.add("IR");
    }


}
