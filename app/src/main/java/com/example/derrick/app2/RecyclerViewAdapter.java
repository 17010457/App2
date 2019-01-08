package com.example.derrick.app2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mTaskNames = new ArrayList<>();
    private ArrayList<String> mCheckbox = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> taskNames, ArrayList<String> checkBox, Context context) {
        this.mTaskNames = taskNames;
        this.mCheckbox = checkBox;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.cbTask.setText(mCheckbox.get(i));
        holder.tvTask.setText(mTaskNames.get(i));
                                                       

        holder.cbTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mCheckbox.get(i) + " completed";
                Toast.makeText(mContext,text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTaskNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox cbTask;
        TextView tvTask;
        LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            cbTask = itemView.findViewById(R.id.checkBox);
            tvTask = itemView.findViewById(R.id.tvTask);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
