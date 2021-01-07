package com.example.firstandroidip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Wishlist extends AppCompatActivity {
    @BindView(R.id.wishlist_textview) TextView wishlist_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String designName = intent.getStringExtra("Details");
        wishlist_textview.setText("Here are all the restaurants near: " + designName);
    }
}