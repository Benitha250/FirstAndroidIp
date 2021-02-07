package com.example.firstandroidip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderFormActivity extends AppCompatActivity {
    public static final String TAG = OrderFormActivity.class.getSimpleName();

    @BindView(R.id.add_to_wishlist) Button add_to_wishlist;
    @BindView(R.id.retrieve) Button retrieve;
    @BindView(R.id.Spinner) Spinner spinner_text;
    @BindView(R.id.opinion) EditText opinion;

    DatabaseReference designsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        ButterKnife.bind(this);

/*        add_to_wishlist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String designName = spinner_text.getSelectedItem().toString();
                Log.d(TAG, designName);
                Intent intent = new Intent(OrderFormActivity.this, Wishlist.class);
                intent.putExtra("Details", designName);
                startActivity(intent);

                *//* Toast.makeText(OrderFormActivity.this, designName, Toast.LENGTH_LONG).show(); *//*

            }
        });*/

        designsData = FirebaseDatabase.getInstance().getReference().child("design");

        add_to_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDesignData();
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderFormActivity.this, Wishlist.class));
            }
        });

    }
    private void insertDesignData(){

        String opinion_edit = opinion.getText().toString();
        String design = spinner_text.getSelectedItem().toString();

        Designs designs = new Designs(opinion_edit,design);

        designsData.push().setValue(designs);
        Toast.makeText(OrderFormActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}