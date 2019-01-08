package com.example.derrick.app2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Create extends AppCompatActivity {

    TextView tvAdd;
    Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Intent intentReceived = getIntent();
        tvAdd = findViewById(R.id.tvAdd);
        btnCreate = findViewById(R.id.btnCreate);

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_Create.this,"Added a Member",Toast.LENGTH_SHORT).show();
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_Create.this,"Created a Discussion",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
