package com.example.derrick.app2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Activity_Settings extends AppCompatActivity {
    Toolbar toolbar;
    SwitchCompat switch1, switch2, switch3, switch4;

    Boolean stateSwitch1, stateSwitch2, stateSwitch3, stateSwitch4;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent intentReceived = getIntent();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = getSharedPreferences("PREF", 0);
        stateSwitch1 = preferences.getBoolean("switch1", false);
        stateSwitch2 = preferences.getBoolean("switch2", false);
        stateSwitch3 = preferences.getBoolean("switch3", false);
        stateSwitch4 = preferences.getBoolean("switch4", false);

        switch1 = findViewById(R.id.switch_1);
        switch2 = findViewById(R.id.switch_2);
        switch3 = findViewById(R.id.switch_3);
        switch4 = findViewById(R.id.switch_4);

        switch1.setChecked(stateSwitch1);
        switch2.setChecked(stateSwitch2);
        switch3.setChecked(stateSwitch3);
        switch4.setChecked(stateSwitch4);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch1 = !stateSwitch1;
                switch1.setChecked(stateSwitch1);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch1", stateSwitch1);
                editor.apply();

            }
        });
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch2 = !stateSwitch2;
                switch2.setChecked(stateSwitch2);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch2", stateSwitch2);
                editor.apply();

            }
        });
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch3 = !stateSwitch3;
                switch3.setChecked(stateSwitch3);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch3", stateSwitch3);
                editor.apply();

            }
        });
        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch4 = !stateSwitch4;
                switch4.setChecked(stateSwitch4);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch4", stateSwitch4);
                editor.apply();

            }
        });

    }
}