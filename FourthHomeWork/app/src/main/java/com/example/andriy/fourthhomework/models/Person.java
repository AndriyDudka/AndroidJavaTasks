package com.example.andriy.fourthhomework.models;

/**
 * Created by Andriy on 01.10.2016.
 */

public class Person {
    private String mName;
    private String mImage;
    private String mPhone;

    public Person(String name, String image, String phone)
    {
        mName = name;
        mImage = image;
        mPhone = phone;
    }

    public String getName(){return mName;}
    public String getPhone(){return mPhone;}
    public String getImage(){return mImage;}
}
