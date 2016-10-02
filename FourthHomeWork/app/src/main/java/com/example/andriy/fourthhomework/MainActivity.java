package com.example.andriy.fourthhomework;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import com.example.andriy.fourthhomework.adapters.PersonAdapter;

import com.example.andriy.fourthhomework.models.Person;

public class MainActivity extends AppCompatActivity {
    private PersonAdapter personAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Person> persons;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new ArrayList<Person>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        personAdapter = new PersonAdapter(this, persons);

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String image = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
            String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            persons.add(new Person(name, image, phone));
        }

        cursor.close();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personAdapter);
    }
}
