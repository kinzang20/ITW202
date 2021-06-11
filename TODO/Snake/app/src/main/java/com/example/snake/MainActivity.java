package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password, confirmpassword;
    Button signup, signin;
    DBHelper DB;
    TextView forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        confirmpassword = (EditText)findViewById(R.id.confirmpassword);
        forget = (TextView)findViewById(R.id.forget);

        signup = (Button)findViewById(R.id.signupbutton);
        signin = (Button)findViewById(R.id.signinbutton);

        DB = new DBHelper(this);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
        forget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signupbutton:
            {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirmpass = confirmpassword.getText().toString();
                if(user.equals(" ") || pass.equals(" ")||confirmpass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(confirmpass))
                    {
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false)
                        {
                            Boolean insert = DB.insertesData(user,pass);
                            if(insert == true)
                            {
                                Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Registration already exists! please sign in",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"password does not match",Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
            case R.id.signinbutton:
            {
                Intent i = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(i);

            }
            break;
            case R.id.forget:
            {
                Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
                startActivity(intent);
            }
            break;
        }

    }
}