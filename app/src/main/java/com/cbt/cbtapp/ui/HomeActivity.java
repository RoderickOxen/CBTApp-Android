package com.cbt.cbtapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cbt.cbtapp.MainActivity;
import com.cbt.cbtapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Declaration
        Button aboutUs = (Button) findViewById(R.id.introText);
        Button enterApp = (Button) findViewById(R.id.enterApp);

        aboutUs.setOnClickListener(HomeActivity.this);
        enterApp.setOnClickListener(HomeActivity.this);

    }

    @Override
    public void onClick(View v) {
        Log.d("mainOnClick", "This is a flagpoint");

        switch (v.getId()){
            case R.id.introText:{
                Uri uri = Uri.parse("https://www.cbtalents.com/about-us");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            }

            case R.id.enterApp:{
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
        }


    }
}
