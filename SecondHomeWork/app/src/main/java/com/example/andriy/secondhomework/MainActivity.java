package com.example.andriy.secondhomework;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
                                                               CompoundButton.OnCheckedChangeListener{

    TextView textViewResult, textViewNumberOne, textViewNumberTwo, textViewOperation;
    int result;

    String LOG_TAG = "myLogs";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = (TextView) findViewById(R.id.resultTextView);
        textViewNumberOne = (TextView) findViewById(R.id.firstNumber);
        textViewNumberTwo = (TextView) findViewById(R.id.secondNumber);
        textViewOperation = (TextView) findViewById(R.id.operation);

        Button button = (Button) findViewById(R.id.buttonResult);
        button.setOnClickListener(this);

        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.switch_compat);
        switchCompat.setOnCheckedChangeListener(this);
    }

    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("result", result);

    }

    protected void onRestoreInstanceState(Bundle bundle){
        super.onRestoreInstanceState(bundle);
        result = bundle.getInt("result");

        textViewResult.setText(Integer.toString(result));
    }

    public void onClick(View view) {
        int firstNumber = Integer.parseInt(textViewNumberOne.getText().toString());
        int secondNumber = Integer.parseInt(textViewNumberTwo.getText().toString());

        switch (textViewOperation.getText().toString()){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case  "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                break;
        }
        textViewResult.setText(Integer.toString(result));
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        View view = (View) findViewById(R.id.activity_main);
        if (isChecked) view.setBackgroundColor(Color.RED);
        else view.setBackgroundColor(Color.BLACK);
    }
}
