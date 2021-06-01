package com.example.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText fname, sname, mark, id;
    Button add, view, delete, update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.fname);
        sname= findViewById(R.id.sname);
        mark = findViewById(R.id.mark);
        id = findViewById(R.id.id);
        add = findViewById(R.id.add);
        view = findViewById(R.id.view);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);

        myDB = new DatabaseHelper(this);

    }

    public void add(View view) {

        boolean isInserted = myDB.insertData(id.getText().toString(),
                fname.getText().toString(),
                sname.getText().toString(),
                mark.getText().toString());

        if(isInserted == true){
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
        }
    }

    public void ViewAll(View view) {

        Cursor res = myDB.getAllData();

        if(res.getCount() == 0){
            showMessage("Error", "Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Student Id: " + res.getString(0)+ "\n");
            buffer.append("Student fname: " + res.getString(1)+ "\n");
            buffer.append("Student sname: " + res.getString(2)+ "\n");
            buffer.append("Student mark: " + res.getString(3)+ "\n\n");

        }
        showMessage("List of Students", buffer.toString());

    }
    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void Update(View view) {
        boolean isUpdate = myDB.UpdateData(id.getText().toString(), fname.getText().toString(),
                sname.getText().toString(), mark.getText().toString());

        if (isUpdate == true){
            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "Data Update failed", Toast.LENGTH_SHORT).show();
        }

    }




    public void delete(View view) {
        boolean isDeleted = myDB.DeleteData(id.getText().toString(), fname.getText().toString(),
                sname.getText().toString(), mark.getText().toString());

        if(isDeleted == true){
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
        }
    }
}