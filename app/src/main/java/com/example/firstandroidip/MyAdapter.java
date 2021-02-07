package com.example.firstandroidip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder> {

    ArrayList<Model> mlist;
    Context context;

    public MyAdapter(Context context, ArrayList<Model> mlist){

        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder)holder;

        Model model = mlist.get(position);
        myViewHolder.opinion_edit.setText(model.getOpinion_edit());
        myViewHolder.design.setText(model.getDesign());

    }

    @Override
    public int getItemCount() {

        return mlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView opinion_edit, design;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            opinion_edit = itemView.findViewById(R.id.opinion);
            design = itemView.findViewById(R.id.designs);
        }
    }
}
