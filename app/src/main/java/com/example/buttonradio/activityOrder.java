package com.example.buttonradio;

import static com.example.buttonradio.R.id.tvCake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class activityOrder extends AppCompatActivity {
    TextView tvCake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tvCake= findViewById(R.id.tvCake);

        Intent intent= getIntent();
        if(intent!=null){
            String cake=intent.getStringExtra("cake");
            tvCake.setText(cake);
        }
    }


}