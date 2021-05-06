package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioButton sameDay, nextDay, pickUp;
    TextView header = (TextView) findViewById(R.id.textView1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        sameDay = (RadioButton) findViewById(R.id.radioButton4);
        nextDay = (RadioButton) findViewById(R.id.radioButton6);
        pickUp = (RadioButton) findViewById(R.id.radioButton5);
        header = (TextView) findViewById(R.id.textView1);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("list");

        header.setText(msg);

        Spinner spinner = findViewById(R.id.spinner);
        //call setOnItemselectedListener if spinner is not null
        if (spinner != null) spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.item_list, android.R.layout.simple_dropdown_item_1line);
        if (spinner != null) {
            spinner.setAdapter(arrayAdapter);
        }

    }

    public void orderItem(View view) {
        boolean itemSelect = ((RadioButton)view).isChecked();

        switch(view.getId()) {
            case R.id.radioButton4:
                displayToast("Same day messenger service");
                break;

            case R.id.radioButton6:
                displayToast("Same day ground delivery");
                break;

            case R.id.radioButton5:
                displayToast("Pick up");
                break;
        }
    }

    private void displayToast(String same_day_messenger_service) {
        Toast.makeText(getApplicationContext(), (CharSequence) sameDay,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        displayToast(message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}