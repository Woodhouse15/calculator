package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void input(View v){
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        TextView textView = findViewById(R.id.calculation);
        String newCalc = textView.getText().toString() + buttonText;
        textView.setText(newCalc);
    }

    public void delete(View v){
        TextView textView = findViewById(R.id.calculation);
        String newCalc = textView.getText().toString();
        if (newCalc.length() > 0) {
            newCalc = newCalc.substring(0, newCalc.length() - 1);
        }
        textView.setText(newCalc);
    }

    public void clear(View v){
        TextView textView = findViewById(R.id.calculation);
        textView.setText("");
    }
}