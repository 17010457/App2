package com.example.derrick.app2;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class Activity_Index extends AppCompatActivity{

    CardView cvJoin,cvCreate,cvTask,cvDiscuss,cvProfile,cvSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Intent intentReceived = getIntent();
        //defining Cards
        cvJoin = findViewById(R.id.cvJoin);
        cvCreate = findViewById(R.id.cvCreate);
        cvTask = findViewById(R.id.cvTask);
        cvDiscuss = findViewById(R.id.cvDiscuss);
        cvProfile = findViewById(R.id.cvProfile);
        cvSettings = findViewById(R.id.cvSettings);

        cvJoin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Activity_Index.this,Activity_Join.class);
                startActivity(intent);
            }
        });
    }

}
