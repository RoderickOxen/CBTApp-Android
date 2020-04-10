package com.cbt.cbtapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cbt.cbtapp.R;

public class CandidateProfileActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_profile);

        //Declaration
        Button send_request = (Button) findViewById(R.id.send_request);

        send_request.setOnClickListener(CandidateProfileActivity.this);

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
