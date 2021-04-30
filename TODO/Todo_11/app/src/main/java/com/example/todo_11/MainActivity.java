package com.example.todo_11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public String mColor[]={"purple_200","purple_500","purple_700","teal_200","teal_700","black","white"};
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
    }

    public void Next(View view) {
        Random random = new Random();
        String colorName= mColor[random.nextInt(4)];
        int colorResourceName = getResources().getIdentifier(colorName, "color",getApplicationContext().getPackageName());
        int colorRs= ContextCompat.getColor(this,colorResourceName);
        textView.setTextColor(colorRs);
    }
    public  void  onSavedInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("color", textView.getCurrentTextColor());
    }

}