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

import com.cbt.cbtapp.models.Candidate;
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

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentsAdapter viewPagerAdapter;
    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> fragmentTitles;
    private ArrayList<Candidate> candidates_talentLeasing = new ArrayList<Candidate>();
    private ArrayList<Candidate> candidates_interRecrut = new ArrayList<Candidate>();

    //Firebase Access
    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference talentLeasingRef = rootRef.child("Tabela-1").child("TalentLeasing");
    private DatabaseReference talentInterRecrutRef = rootRef.child("Tabela-2").child("InternationalRecruitment");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get data from firebase
        getCandidatesTalentLeasing(talentLeasingRef);

        tabLayout = findViewById(R.id.BottomTab);
        viewPager = findViewById(R.id.ViewPager);
    }

    private void viewPagerTabLayout(){
        viewPagerAdapter = new FragmentsAdapter(getSupportFragmentManager(), this, fragmentArrayList, fragmentTitles);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_airplanemode_active_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_flag_black_24dp);

    }

    private void setFragmentArrayList(){
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new MainFragment1(candidates_talentLeasing));
        fragmentArrayList.add(new MainFragment2());
    }

    private void setFragmentTitles(){
        fragmentTitles = new ArrayList<>();
        fragmentTitles.add("TL");
        fragmentTitles.add("IR");

    }

    private void getCandidatesTalentLeasing(DatabaseReference talentLeasingRef) {
        talentLeasingRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    Candidate candidate = new Candidate(
                            ds.getKey(),
                            ds.child("Title").getValue().toString(),
                            ds.child("AcademicBackground").getValue().toString(),
                            ds.child("Keywords").getValue().toString(),
                            ds.child("Motivation to work abroad").getValue().toString(),
                            ds.child("Relevant Industries").getValue().toString(),
                            ds.child("Residence").getValue().toString(),
                            ds.child("Salary Expectation").getValue().toString(),
                            ds.child("YearsOfExperience").getValue().toString());

                    candidates_talentLeasing.add(candidate);

                    //Logs for debugging
                    Log.w("ID", String.valueOf(ds.getKey()));
                    Log.w("AcademicBackground", String.valueOf(ds.child("AcademicBackground").getValue()));
                    Log.w("Keywords", String.valueOf(ds.child("Keywords").getValue()));
                    Log.w("Motivation", String.valueOf(ds.child("Motivation to work abroad").getValue()));
                    Log.w("Relevant", String.valueOf(ds.child("Relevant Industries").getValue()));
                    Log.w("Residence", String.valueOf(ds.child("Residence").getValue()));
                    Log.w("Salary", String.valueOf(ds.child("Salary Expectation").getValue()));
                    Log.w("YearsOfExperience", String.valueOf(ds.child("YearsOfExperience").getValue()));

                }
                //After getting the data you call the next part
                getCandidatesInternationalRecruitment(talentInterRecrutRef);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }

    private void getCandidatesInternationalRecruitment(DatabaseReference talentLeasingRef) {
        talentLeasingRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    Candidate candidate = new Candidate(
                            ds.getKey(),
                            ds.child("Title").getValue().toString(),
                            ds.child("AcademicBackground").getValue().toString(),
                            ds.child("Keywords").getValue().toString(),
                            ds.child("Motivation to work abroad").getValue().toString(),
                            ds.child("Relevant Industries").getValue().toString(),
                            ds.child("Residence").getValue().toString(),
                            ds.child("Salary Expectation").getValue().toString(),
                            ds.child("YearsOfExperience").getValue().toString());

                    candidates_interRecrut.add(candidate);

                    //Logs for debugging
                    Log.w("ID", String.valueOf(ds.getKey()));
                    Log.w("AcademicBackground", String.valueOf(ds.child("AcademicBackground").getValue()));
                    Log.w("Keywords", String.valueOf(ds.child("Keywords").getValue()));
                    Log.w("Motivation", String.valueOf(ds.child("Motivation to work abroad").getValue()));
                    Log.w("Relevant", String.valueOf(ds.child("Relevant Industries").getValue()));
                    Log.w("Residence", String.valueOf(ds.child("Residence").getValue()));
                    Log.w("Salary", String.valueOf(ds.child("Salary Expectation").getValue()));
                    Log.w("YearsOfExperience", String.valueOf(ds.child("YearsOfExperience").getValue()));

                }
                //After getting the data you call the next part
                setFragmentArrayList();
                setFragmentTitles();
                viewPagerTabLayout();

                Log.w("size-TL", String.valueOf(candidates_talentLeasing.size()));
                Log.w("size-IR", String.valueOf(candidates_interRecrut.size()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }


}
