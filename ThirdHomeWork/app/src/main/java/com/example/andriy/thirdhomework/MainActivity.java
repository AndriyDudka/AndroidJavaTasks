package com.example.andriy.thirdhomework;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewFirstNumber, textViewSecondNumber, textViewResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFirstNumber = (TextView) findViewById(R.id.textViewFirstNumber);
        textViewSecondNumber = (TextView) findViewById(R.id.textViewSecondNumber);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        Button buttonFirstNumber = (Button) findViewById(R.id.buttonFirstNumber);
        Button buttonSecondNumber = (Button) findViewById(R.id.buttonSecondNumber);
        Button buttonResult = (Button) findViewById(R.id.buttonResult);

        buttonFirstNumber.setOnClickListener(this);
        buttonSecondNumber.setOnClickListener(this);
        buttonResult.setOnClickListener(this);

        ImageButton buttonGoogle = (ImageButton) findViewById(R.id.buttonGoogle);
        ImageButton buttonCall = (ImageButton) findViewById(R.id.buttonCall);
        ImageButton buttonSms = (ImageButton) findViewById(R.id.buttonSms);

        buttonGoogle.setOnClickListener(this);
        buttonCall.setOnClickListener(this);
        buttonSms.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.buttonFirstNumber:
                intent = new Intent(this, FirstNumberActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.buttonSecondNumber:
                intent = new Intent(this, SecondNumberActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.buttonGoogle:
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, textViewResult.getText().toString());
                startActivity(intent);
                break;
            case R.id.buttonCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + textViewResult.getText().toString()));
                startActivity(intent);
                break;
            case R.id.buttonSms:
                Uri uri = Uri.parse("smsto:" + textViewResult.getText().toString());
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
            default:
                textViewResult.setText(Integer.toString(Integer.parseInt(textViewFirstNumber.getText().toString()) +
                                       Integer.parseInt(textViewSecondNumber.getText().toString())));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null){
            return;
        }

        if (data.getStringExtra("firstNumber") != null)
            textViewFirstNumber.setText(data.getStringExtra("firstNumber"));
        if (data.getStringExtra("secondNumber") != null)
            textViewSecondNumber.setText(data.getStringExtra("secondNumber"));
    }
}
