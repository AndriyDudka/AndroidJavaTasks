package Models;

/**
 * Created by Andriy on 01.10.2016.
 */

public class Person {

    private String _name;
    private String _image;
    private String _phone;

    public Person(String name, String image, String phone)
    {
        _name = name;
        _image = image;
        _phone = phone;
    }



    public String getName(){
        return _name;
    }
    public String getPhone(){
        return _phone;
    }
    public String getImage(){
        return _image;
    }


}
