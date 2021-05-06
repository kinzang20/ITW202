package com.example.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String LOG = MainActivity.class.getName();
    FloatingActionButton floatingActionButton;
    String list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.callFloatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });
    }

    public void donut(View view) {
        String donut = "You ordered a donut";
        list = donut;
        Toast.makeText(this, "You ordered a donut", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Order2:
                Intent intent = new Intent(com.example.todo_12.MainActivity.this, OrderActivity.class);
                intent.putExtra("list", list);
                startActivity(intent);
                return true;

            case R.id.Order1:
                displayToast("You have selected your Order");
                return true;

            case R.id.Order3:
                displayToast("You have selected your About");
                return true;

            case R.id.Order4:
                displayToast("You have selected your Notification");
                return true;
        }
        return true;
    }

    private void displayToast(String you_have_selected_your_contact) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void ice_cream(View view) {
        String ice = "You ordered a ice cream";
        list = ice;
        Toast.makeText(this,"You ordered a ice cream",Toast.LENGTH_SHORT).show();
    }

    public void froyo(View view) {
        String froyo = "You ordered a froyo";
        list = froyo;
        Toast.makeText(this,"You ordered a froyo",Toast.LENGTH_SHORT).show();
    }
}


