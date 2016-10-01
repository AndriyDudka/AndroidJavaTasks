package Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andriy.fourthhomework.R;

import java.util.List;

import Models.Person;

/**
 * Created by Andriy on 01.10.2016.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonsHolder> {

    private List<Person> persons;

    public PersonAdapter(List<Person> persons){
        this.persons = persons;
    }

    public PersonsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adressbook_item, parent, false);
        return new PersonsHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonsHolder holder, int position) {
        Person person = persons.get(position);
        holder.bindCrime(person);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
