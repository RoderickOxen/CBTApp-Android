package com.cbt.cbtapp.ui;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cbt.cbtapp.R;
import com.cbt.cbtapp.models.Candidate;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MainFragmentAdapter extends RecyclerView.Adapter<MainFragmentAdapter.ViewHolder> {

    //Candidates
    ArrayList<Candidate> candidates = new ArrayList<Candidate>();

    //TO DOO
    private LayoutInflater inflater;
    Context context;



    public MainFragmentAdapter(Context ct, ArrayList<Candidate> c){
        context = ct;
        candidates = c;
        inflater = LayoutInflater.from(ct);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.talent_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainFragmentAdapter.ViewHolder holder, final int position) {
        holder.candidate_title.setText(candidates.get(position).getCandidate_title());
        holder.candidate_residence.setText("Residence: "+candidates.get(position).getCandidate_residence());
        holder.candidate_experience.setText("Years of Experience: "+candidates.get(position).getCandidate_experience()+" years");
        holder.candidate_flag.setImageBitmap(candidates.get(position).getCandidate_image());

        holder.theLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CandidateProfileActivity.class);
                Candidate candidate = candidates.get(position);
                intent.putExtra("candidate", new Gson().toJson(candidate));
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return candidates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        androidx.constraintlayout.widget.ConstraintLayout theLayout;

        TextView candidate_title;
        TextView candidate_residence;
        TextView candidate_experience;
        ImageView candidate_flag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            candidate_title = itemView.findViewById(R.id.textView1);
            candidate_residence =  itemView.findViewById(R.id.distanceTime);
            candidate_experience =  itemView.findViewById(R.id.queueTime);
            candidate_flag = itemView.findViewById(R.id.imageView1);
            theLayout = itemView.findViewById(R.id.theLayout);
        }
    }
}
