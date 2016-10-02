package Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.andriy.fourthhomework.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import Models.Person;

/**
 * Created by Andriy on 01.10.2016.
 */

public class PersonsHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView name;
    private TextView phone;
    private Person person;

    public PersonsHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image);
        name = (TextView) itemView.findViewById(R.id.name);
        phone = (TextView) itemView.findViewById(R.id.phonenumber);
    }

    public void bindCrime(Person person){
        this.person = person;
        name.setText(person.getName());
        phone.setText(person.getPhone());
        if (person.getImage() == null){
            image.setImageResource(R.drawable.ic_contact);
        } else{
            image.setImageURI(Uri.parse(person.getImage()));
        }
    }
}
