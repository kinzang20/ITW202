package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    private Calculator mcalculater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.textView1);
        editText2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.textView4);
    }

    public void add(View view) {
        String first_number=editText1.getText().toString();
        String second_number=editText2.getText().toString();
        Double value = mcalculater.add(Double.valueOf(first_number),Double.valueOf(second_number));
        textView.setText(String.valueOf(value));
    }

    public void sub(View view) {
        String first_number=editText1.getText().toString();
        String second_number=editText2.getText().toString();
        Double value = mcalculater.sub(Double.valueOf(first_number),Double.valueOf(second_number));
        textView.setText(String.valueOf(value));
    }

    public void mul(View view) {
        String first_number=editText1.getText().toString();
        String second_number=editText2.getText().toString();
        Double value = mcalculater.mul(Double.valueOf(first_number),Double.valueOf(second_number));
        textView.setText(String.valueOf(value));
    }

    public void div(View view) {
        String first_number=editText1.getText().toString();
        String second_number=editText2.getText().toString();
        Double value = mcalculater.div(Double.valueOf(first_number),Double.valueOf(second_number));
        textView.setText(String.valueOf(value));
    }
}