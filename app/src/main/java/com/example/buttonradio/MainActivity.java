package com.example.buttonradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner label_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        label_spinner=findViewById(R.id.label_spinner);
        label_spinner.setOnItemSelectedListener(this);

    }
    public void onRadioButtonClicked(View view) {
        switch (view.getId()){
            case R.id.sameday:
                displayToast(getString(R.string.same_day_service));
                break;
            case R.id.nextday:
                displayToast(getString(R.string.next_day));
                break;
            default:
                break;


        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String spinnerLabel=adapterView.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}