package com.example.firstandroidip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> arrayList;
    Context context;

    public MyAdapter(Context context, ArrayList<Model> arrayList){

        this.arrayList = arrayList;
        this.context = context;
    }

    public MyAdapter(FirebaseRecyclerOptions<Model> options) {
        super();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_view_layout, parent, false);
        return new MyViewHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getRef().removeValue();
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model model = arrayList.get(position);
        holder.designTextView.setText("Design: "+model.getDesign());
        holder.opinionTextView.setText("Opinion: "+model.getOpinion_edit());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView designTextView, opinionTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            designTextView = itemView.findViewById(R.id.designTextView);
            opinionTextView = itemView.findViewById(R.id.opinionTextView);
        }
    }
}
