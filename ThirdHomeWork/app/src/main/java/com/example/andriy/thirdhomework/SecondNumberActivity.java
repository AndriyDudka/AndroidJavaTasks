package com.example.andriy.thirdhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondNumberActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextSecondNumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_number);

        editTextSecondNumber = (EditText) findViewById(R.id.editTextSecondNumber);

        Button button = (Button) findViewById(R.id.buttonCancelSecondNumber);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("secondNumber", editTextSecondNumber.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
