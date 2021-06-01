package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name, address, phone, note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        note = findViewById(R.id.note);

        Intent obj = getIntent();
        String text = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView message =  findViewById(R.id.message);
        message.setText(text);

        Spinner spinner = findViewById(R.id.spinner);
        if (spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.label_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void back(View view) {
        Intent obj = new Intent(OrderActivity.this, MainActivity.class);
        startActivity(obj);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void Button_Checked(View view) {
        //Checked true if button is checked
        boolean checked = ((RadioButton) view).isChecked();
        //check which radio button was clicked
        switch (view.getId()){

            case R.id.radioButton:
                if (checked){
                    displayToast(getString(R.string.msg1));
                }
                break;
            case R.id.radioButton2:
                if (checked){
                    displayToast(getString(R.string.msg2));
                }
                break;
            case R.id.radioButton3:
                if(checked){
                    displayToast(getString(R.string.msg3));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //nothing

    }
}