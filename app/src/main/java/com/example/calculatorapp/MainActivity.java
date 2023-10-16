package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.udojava.evalex.Expression;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void input(View v){
        TextView result = findViewById(R.id.result);
        TextView textView = findViewById(R.id.calculation);
        if(!result.getText().toString().equals("")){
            textView.setText("");
        }
        result.setText("");
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        String newCalc = textView.getText().toString() + buttonText;
        textView.setText(newCalc);
    }

    public void delete(View v){
        TextView result = findViewById(R.id.result);
        result.setText("");
        TextView textView = findViewById(R.id.calculation);
        String newCalc = textView.getText().toString();
        if (newCalc.length() > 0) {
            newCalc = newCalc.substring(0, newCalc.length() - 1);
        }
        textView.setText(newCalc);
    }

    public void clear(View v){
        TextView textView = findViewById(R.id.calculation);
        TextView result = findViewById(R.id.result);
        result.setText("");
        textView.setText("");
    }

    public void equals(View v) {
        TextView textView = findViewById(R.id.calculation);
        String val = textView.getText().toString();
        TextView result = findViewById(R.id.result);
        try{
            Expression expression=new Expression(val);
            String abc=expression.eval().toString(); //Insert The Data into A String
            result.setText(abc);
        }catch(ArithmeticException e){
            result.setText(R.string.cannot_divide_by_0);
        }

    }
}