package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextwebsite;
    private EditText editTextLocation;
    private  EditText editTextshare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextwebsite = findViewById(R.id.edt1);
        editTextLocation = findViewById(R.id.edt2);
        editTextshare = findViewById(R.id.edt3);
    }

    public void OpenWeb(View view) {
        String msg = editTextwebsite.getText().toString();
        Uri url = Uri.parse(msg);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("implicit", "error");
        }
    }

    public void Openloc(View view) {
        String msg = editTextLocation.getText().toString();
        Uri url = Uri.parse("geo:0,0?q="+ msg);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("implicit", "error");
    }
}

    public void sharet(View view) {
        String txt = editTextshare.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
               .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: share")
                .setText(txt)
                .startChooser();

    }
    }