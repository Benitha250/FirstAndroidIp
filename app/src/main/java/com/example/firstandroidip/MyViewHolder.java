package com.example.firstandroidip;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView designTextView, opinionTextView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        designTextView = itemView.findViewById(R.id.designTextView);
        opinionTextView = itemView.findViewById(R.id.opinionTextView);

    }
}
