package com.example.derrick.app2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Activity_Discuss extends AppCompatActivity {

    LinearLayout discuss1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);
        Intent intentReceived = getIntent();

        discuss1 = findViewById(R.id.discuss1);

        discuss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Discuss.this,Activity_Discussion.class);
                startActivity(intent);
            }
        });
    }
}
