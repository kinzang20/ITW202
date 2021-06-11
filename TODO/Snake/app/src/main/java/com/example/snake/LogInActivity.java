package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Logger;

public class LogInActivity extends AppCompatActivity {
    EditText username, password;
    Button loginbtn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username =(EditText)findViewById(R.id.username1);
        password =(EditText)findViewById(R.id.password1);

        loginbtn = (Button)findViewById(R.id.signinbutton1);
        DB = new DBHelper(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals(" ")||pass.equals(""))
                {
                    Toast.makeText(LogInActivity.this,"please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(LogInActivity.this,"sign in successfully",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainCategory.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(LogInActivity.this,"Invaild Credentials",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}