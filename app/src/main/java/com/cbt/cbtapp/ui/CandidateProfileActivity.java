package com.cbt.cbtapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.cbt.cbtapp.models.Candidate;
import androidx.appcompat.app.AppCompatActivity;
import com.cbt.cbtapp.R;
import com.google.gson.Gson;

public class CandidateProfileActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_profile);

        //Declaration
        Button send_request = (Button) findViewById(R.id.send_request);

        send_request.setOnClickListener(CandidateProfileActivity.this);

        String jsonMyObject;
        Bundle bundle = getIntent().getExtras();

        jsonMyObject = bundle.getString("candidate");
        Candidate candidate = new Gson().fromJson(jsonMyObject, Candidate.class);

        TextView textView = findViewById(R.id.title);
        textView.setText(candidate.getCandidate_title());

        textView = findViewById(R.id.id);
        textView.setText("ID: "+candidate.getCandidate_id());

        textView = findViewById(R.id.residence);
        textView.setText("Nationality: "+candidate.getCandidate_nationality());

        textView = findViewById(R.id.residence2);
        textView.setText(candidate.getCandidate_residence());

        textView = findViewById(R.id.experience);
        textView.setText(candidate.getCandidate_experience()+" years");

        textView = findViewById(R.id.academic);
        textView.setText(candidate.getCandidate_academic());

        textView = findViewById(R.id.industries);
        textView.setText(candidate.getCandidate_industries());

        textView = findViewById(R.id.salary);
        textView.setText(candidate.getCandidate_salary());

        textView = findViewById(R.id.motivation);
        textView.setText(candidate.getCandidate_motivation());




        ImageView image = findViewById(R.id.res_image);
        if (candidate.getCandidate_nationality().toLowerCase().equals("portuguese")){
            image.setImageResource(R.drawable.portuguese);
        }
        else if (candidate.getCandidate_nationality().toLowerCase().equals("spannish")){
            image.setImageResource(R.drawable.portuguese);
        }
        else if (candidate.getCandidate_nationality().toLowerCase().equals("british")){
            image.setImageResource(R.drawable.uk);
        }
        else if (candidate.getCandidate_nationality().toLowerCase().equals("german")){
            image.setImageResource(R.drawable.germany);
        }
        else if (candidate.getCandidate_nationality().toLowerCase().equals("italian")){
            image.setImageResource(R.drawable.italian);
        }
        else if (candidate.getCandidate_nationality().toLowerCase().equals("brazilian")){
            image.setImageResource(R.drawable.brazil);
        }







        textView = findViewById(R.id.keywords);
        textView.setText(candidate.getCandidate_keyowrds());

    }

    @Override
    public void onClick(View view) {
        Log.d("mainOnClick", "This is a flagpoint");

        switch (view.getId()){

            case R.id.send_request:{
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","cbt@cbt.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Profile request");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi, i am interested in this candidate");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        }
    }

}

