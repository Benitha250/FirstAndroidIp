package com.example.firstandroidip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderFormActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.add_to_wishlist) Button add_to_wishlist;
    @BindView(R.id.Spinner) Spinner spinner_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        ButterKnife.bind(this);

        add_to_wishlist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String designName = spinner_text.getSelectedItem().toString();
                Log.d(TAG, designName);
                Intent intent = new Intent(OrderFormActivity.this, Wishlist.class);
                intent.putExtra("Details", designName);
                startActivity(intent);

                /* Toast.makeText(OrderFormActivity.this, designName, Toast.LENGTH_LONG).show(); */

            }
        });
    }
}