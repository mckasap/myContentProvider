package org.kasapbasi.mycontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGrade = (EditText) findViewById(R.id.editTextTextPersonName2);
        etName = (EditText)findViewById(R.id.editTextTextPersonName);

    }

    public void onClickAdd(View v){

        Toast.makeText(this, "onClickAdd Button Pressed" +etName.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrive(View v){

        Toast.makeText(this, "onClickRetrive Button Pressed", Toast.LENGTH_LONG).show();
    }

}