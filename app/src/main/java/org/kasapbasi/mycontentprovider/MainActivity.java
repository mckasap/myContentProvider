package org.kasapbasi.mycontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
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

        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME, etName.getText().toString());

        values.put(StudentsProvider.GRADE, etGrade.getText().toString());

        Uri uri = getContentResolver().insert(
                StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();

        Toast.makeText(this, "onClickAdd Button Pressed" +etName.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrive(View v){

        // Retrieve student records
        String URL = "content://org.kasapbasi.mycontentprovider.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
        Toast.makeText(this, "onClickRetrive Button Pressed", Toast.LENGTH_LONG).show();
    }

}