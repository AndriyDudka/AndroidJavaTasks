package com.example.andriy.fourthhomework;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapters.PersonAdapter;
import Data.PersonsFactory;
import Models.Person;

public class MainActivity extends AppCompatActivity {

    private PersonAdapter personAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Person> persons;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new ArrayList<Person>();

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String image = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                persons.add(new Person(name, image, phone));
            }
        }

        cursor.close();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //List<Person> persons = PersonsFactory.GetCloneList();

        personAdapter = new PersonAdapter(persons);

        recyclerView.setAdapter(personAdapter);
    }
}
