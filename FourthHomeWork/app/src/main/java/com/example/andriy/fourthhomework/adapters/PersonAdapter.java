package com.example.andriy.fourthhomework.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.andriy.fourthhomework.R;
import java.util.ArrayList;
import com.example.andriy.fourthhomework.models.Person;

/**
 * Created by Andriy on 01.10.2016.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonsHolder> {

    public static class PersonsHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private TextView mName;
        private TextView mPhone;

        public PersonsHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.image);
            mName = (TextView) itemView.findViewById(R.id.name);
            mPhone = (TextView) itemView.findViewById(R.id.phonenumber);
        }
    }

    private ArrayList<Person> persons;
    public Context mContext;

    public PersonAdapter(Context context, ArrayList<Person> persons){
        this.persons = persons;
        mContext = context;
    }

    public PersonsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adressbook_item, parent, false);
        return new PersonsHolder(view);
    }

    public void onBindViewHolder(PersonsHolder holder, int position) {
        Person person = persons.get(position);

        holder.mName.setText(person.getName());
        holder.mPhone.setText(person.getPhone());
        if (person.getImage() == null){
            holder.mImage.setImageResource(R.drawable.ic_contact);
        } else{
            holder.mImage.setImageURI(Uri.parse(person.getImage()));
        }
    }

    public int getItemCount() {
        return persons.size();
    }
}
