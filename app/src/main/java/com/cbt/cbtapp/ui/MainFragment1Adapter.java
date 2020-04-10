package com.cbt.cbtapp.ui;


import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cbt.cbtapp.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MainFragment1Adapter extends RecyclerView.Adapter<MainFragment1Adapter.ViewHolder> {

    ArrayList<String> rest_names = new ArrayList<String>();
    ArrayList<String> rest_id = new ArrayList<String>();

    int images;
    private LayoutInflater inflater;


    public MainFragment1Adapter(Context ct, ArrayList<String> id, ArrayList<String> name, int img){
        rest_id = id;
        rest_names = name;

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
    public void onBindViewHolder(@NonNull MainFragment1Adapter.ViewHolder holder, int position) {
        holder.textView.setText(rest_names.get(position));
        holder.imageView.setImageResource(R.drawable.ic_android_black_24dp);
    }

    @Override
    public int getItemCount() {
        return rest_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textDistance;
        TextView textqueue;
        ImageView imageView;
        androidx.constraintlayout.widget.ConstraintLayout theLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textDistance =  itemView.findViewById(R.id.distanceTime);
            textqueue =  itemView.findViewById(R.id.queueTime);
            textView = itemView.findViewById(R.id.textView1);
            imageView = itemView.findViewById(R.id.imageView1);
            theLayout = itemView.findViewById(R.id.theLayout);
        }
    }
}
