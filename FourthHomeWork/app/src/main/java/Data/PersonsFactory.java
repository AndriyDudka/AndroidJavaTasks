package Data;
import java.util.ArrayList;
import java.util.List;

import Models.Person;

/**
 * Created by Andriy on 01.10.2016.
 */

public class PersonsFactory {

    private static PersonsFactory sPersonsFactory;
    private static ArrayList<Person> persons;

    private PersonsFactory(){
        persons = new ArrayList<Person>(10);
        for (int i = 1; i <= 10; i++){
            persons.add(new Person("DudkaClon#" + i, "@drawable/ic_google", "+380668839420"));
        }
    }

    public static List<Person> GetCloneList(){
        if (sPersonsFactory == null){
            sPersonsFactory = new PersonsFactory();
        }
        return persons;
    }
}
