package com.example.buttonradio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner label_spinner;
    String cake ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        label_spinner=findViewById(R.id.label_spinner);
        label_spinner.setOnItemSelectedListener(this);

    }
    public void onclick(View view) {
        Intent intent= new Intent(this,activityOrder.class);
        intent.putExtra("cake",cake);
        startActivity(intent);

    }
    public void orderCake(View view) {
        if (view.getId() == R.id.imagedonut) {
            cake="donut";
            Toast.makeText(this, R.string.donut_order, Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.imageicecream) {
            cake="icecream";
            Toast.makeText(this, R.string.ice_cream_order, Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.imagecake) {
            cake="cake";
            Toast.makeText(this, R.string.cake_order, Toast.LENGTH_SHORT).show();
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void order(MenuItem item) {
        displayToast("Order");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_order:
                AlertDialog.Builder myalert= new AlertDialog.Builder(MainActivity.this);
                myalert.setTitle("Thnah toan");
                myalert.show();
                myalert.setMessage("Sure?");
                myalert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(this,activityOrder.class));
                    }
                });
                DatePickerDialog date= new DatePickerDialog(this, (view,year,month,dayOfMonth
                )->{},2022,7,12);

           case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
            case R.id.action_setting:
                displayToast(getString(R.string.action_status_message));

        }
        return super.onOptionsItemSelected(item);
    }
}