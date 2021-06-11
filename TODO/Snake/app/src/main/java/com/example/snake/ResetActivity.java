package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResetActivity extends AppCompatActivity {
    TextView username;
    EditText pass, confirmpass;
    Button confirmbutton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        username = (TextView)findViewById(R.id.username_reset_text);
        pass = (EditText)findViewById(R.id.resetpassword);
        confirmpass =(EditText)findViewById(R.id.confirmresetpassword);
        confirmbutton = (Button)findViewById(R.id.btnconfirm);
        DB = new DBHelper(this);
        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String password = pass.getText().toString();
                String repassword = confirmpass.getText().toString();
                if(repassword.equals(password)) {
                    Boolean checkpasswordupdate = DB.updatepassword(user, password);
                    if (checkpasswordupdate == true) {
                        Intent intent1 = new Intent(getApplicationContext(), LogInActivity.class);
                        startActivity(intent1);
                        Toast.makeText(ResetActivity.this, "password reset successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetActivity.this, "password not reset", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    Toast.makeText(ResetActivity.this, "password doesnot match", Toast.LENGTH_SHORT).show();
                }

            }
        });
       // finish();
    }
}