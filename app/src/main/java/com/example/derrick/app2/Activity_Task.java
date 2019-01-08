package com.example.derrick.app2;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.WithHint;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity_Task extends AppCompatActivity {

    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> checkBox = new ArrayList<>();
    private String m_Text;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button btnRemove;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intentReceived = getIntent();
        btnRemove = findViewById(R.id.btnRemovetask);
        btnAdd = findViewById(R.id.btnAddtask);

        initListItem();

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_Task.this, "Removed task", Toast.LENGTH_SHORT).show();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Task.this);
                builder.setTitle("Add Task Name");

// Set up the input
                final EditText input = new EditText(Activity_Task.this);


// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        Calendar cal = Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog dialog2 = new DatePickerDialog(Activity_Task.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                                mDateSetListener,
                                year,month,day);
                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog2.show();

                    }
                });

                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        Toast.makeText(Activity_Task.this, "Task Added", Toast.LENGTH_SHORT).show();

                    }
                };
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void initListItem() {
        checkBox.add("Finish Portfolio App 2");
        taskNames.add("9/1/2019");

        checkBox.add("Complete Worksheet");
        taskNames.add("12/1/2019");

        checkBox.add("Complete Module Selection");
        taskNames.add("21/1/2019");

        checkBox.add("Complete Xcode Project");
        taskNames.add("29/2/2019");

        checkBox.add("Go for Hackathon Event");
        taskNames.add("16/3/2019");

        checkBox.add("Complete Survey");
        taskNames.add("4/6/2019");
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rvTask);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(taskNames, checkBox, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
