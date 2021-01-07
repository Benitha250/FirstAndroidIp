package com.example.firstandroidip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button) Button button;
    @BindView(R.id.wishlist_textview) TextView wishlist_textview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListDesignActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String designName = intent.getStringExtra("Details");
        wishlist_textview.setText("Here are all the restaurants near: " + designName);


    }
}