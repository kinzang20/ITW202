package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.todo_12";

    String mOrderMessage;

    ImageView donut, ice, froyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donut = findViewById(R.id.donut);
        ice = findViewById(R.id.ice);
        froyo = findViewById(R.id.froyo);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();

    }

    public void donuts(View view) {
        mOrderMessage = getString(R.string.order_donut_message);
        displayToast(mOrderMessage);
    }

    public void icecream(View view) {
        mOrderMessage = getString(R.string.order_ice_message);
        displayToast(mOrderMessage);
    }

    public void froyo(View view) {
        mOrderMessage = getString(R.string.order_froyo_message);
        displayToast(mOrderMessage);
    }


    public void call(View view) {
        Intent i = new Intent(MainActivity.this, OrderActivity.class);
        i.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(i);
    }


}