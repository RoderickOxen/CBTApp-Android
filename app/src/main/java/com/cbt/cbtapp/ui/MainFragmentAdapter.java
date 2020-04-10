package com.cbt.cbtapp.ui;


import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cbt.cbtapp.R;
import com.cbt.cbtapp.models.Candidate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MainFragmentAdapter extends RecyclerView.Adapter<MainFragmentAdapter.ViewHolder> {

    ArrayList<Candidate> candidates_talentLeasing = new ArrayList<Candidate>();

    //TO DOO
    Bitmap images;
    private LayoutInflater inflater;


    public MainFragmentAdapter(Context ct, ArrayList<Candidate> candidates, Bitmap img){
        candidates_talentLeasing = candidates;
        images = img;
        inflater = LayoutInflater.from(ct);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.talent_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainFragmentAdapter.ViewHolder holder, int position) {
        holder.candidate_title.setText(candidates_talentLeasing.get(position).getCandidate_title());
        holder.candidate_residence.setText("Residence: "+candidates_talentLeasing.get(position).getCandidate_residence());
        holder.candidate_experience.setText("Years of Experience: "+candidates_talentLeasing.get(position).getCandidate_experience()+" years");
        holder.imageView.setImageBitmap(images);

        //holder.imageView.setImageResource(R.drawable.ic_android_black_24dp);
    }

    @Override
    public int getItemCount() {
        return candidates_talentLeasing.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView candidate_title;
        TextView candidate_residence;
        TextView candidate_experience;

        ImageView imageView;
        androidx.constraintlayout.widget.ConstraintLayout theLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            candidate_title = itemView.findViewById(R.id.textView1);
            candidate_residence =  itemView.findViewById(R.id.distanceTime);
            candidate_experience =  itemView.findViewById(R.id.queueTime);
            imageView = itemView.findViewById(R.id.imageView1);
            theLayout = itemView.findViewById(R.id.theLayout);
        }
    }
}
