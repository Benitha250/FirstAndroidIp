package com.example.firstandroidip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListDesignActivity extends AppCompatActivity {

    int[] images = {R.drawable.dress1, R.drawable.dress2, R.drawable.dress3, R.drawable.dress4, R.drawable.dress5, R.drawable.jumpsuit};

    String[] design = {"Wedding dress", "casual dress", "summer dress", "Occassional dress", "offshoulder dress", "Jumpsuit"};

    String[] description = {"Elegant dress on small price.", "Elegant dress on small price.", "Elegant dress on small price.", "Elegant dress on small price.", "Elegant dress on small price.", "Elegant dress on small price."};

    ListView lView;

    ListAdapter lAdapter;

    @BindView(R.id.wishlist_button) Button wishlist_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_design);

        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new ListAdapter(ListDesignActivity.this, design, description, images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ListDesignActivity.this, design[i]+" "+description[i], Toast.LENGTH_SHORT).show();

            }
        });

        ButterKnife.bind(this);
        wishlist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListDesignActivity.this, OrderFormActivity.class);
            }
        });


    }
}