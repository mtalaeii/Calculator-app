package com.mtalaeii.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity implements onNumberAndDotClick,onOperatorsClick{
    private EditText editText;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonDot;
    private Button buttonPositive;
    private Button buttonNegative;
    private Button buttonMultiple;
    private Button buttonDivision;
    private Button buttonC;
    private Button buttonEqual;
    private float mValueOne, mValueTwo;
    private boolean Addition = false, mSubtract = false, Multiplication = false, Division = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetupViews();
    }

    private void SetupViews() {
        editText = findViewById(R.id.editText);
        button0 = findViewById(R.id.button0);
        onClicked(button0,editText,"0");
        button1 = findViewById(R.id.button1);
        onClicked(button1,editText,"1");
        button2 = findViewById(R.id.button2);
        onClicked(button2,editText,"2");
        button3 = findViewById(R.id.button3);
        onClicked(button3,editText,"3");
        button4 = findViewById(R.id.button4);
        onClicked(button4,editText,"4");
        button5 = findViewById(R.id.button5);
        onClicked(button5,editText,"5");
        button6 = findViewById(R.id.button6);
        onClicked(button6,editText,"6");
        button7 = findViewById(R.id.button7);
        onClicked(button7,editText,"7");
        button8 = findViewById(R.id.button8);
        onClicked(button8,editText,"8");
        button9 = findViewById(R.id.button9);
        onClicked(button9,editText,"9");
        buttonDot = findViewById(R.id.buttonDot);
        onClicked(buttonDot,editText,".");
        buttonPositive = findViewById(R.id.buttonPositive);
        onClicked(buttonPositive,"+",editText);
        buttonNegative = findViewById(R.id.buttonNegative);
        onClicked(buttonNegative,"-",editText);
        buttonMultiple = findViewById(R.id.buttonMultiple);
        onClicked(buttonMultiple,"x",editText);
        buttonDivision = findViewById(R.id.buttonDivision);
        onClicked(buttonDivision,"/",editText);
        buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(v -> {
            editText.setText("");
        });
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(v -> {
            try {
                mValueTwo = Float.parseFloat(editText.getText()+"");
                if(Addition){

                    editText.setText(mValueOne+mValueTwo+"");
                    Addition = false;
                }
                if(mSubtract){
                    editText.setText(mValueOne - mValueTwo+"");
                    mSubtract = false;
                }
                if(Multiplication){
                    editText.setText(mValueOne * mValueTwo+"");
                    Multiplication = false;
                }
                if(Division){
                    mValueTwo /= mValueOne;
                    editText.setText(mValueOne / mValueTwo+"");
                    Division = false;
                }
            }catch (Exception e){
                Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
            }

        });

    }

    @Override
    public void onClicked(Button button, EditText editText, String n) {
        button.setOnClickListener(v -> {
            editText.setText(editText.getText() + n);
        });
    }


    @Override
    public void onClicked(Button button, String s, EditText editText) {
        button.setOnClickListener(v -> {
            try {
                switch (s){
                    case "+":
                        mValueOne = Float.parseFloat(editText.getText()+"");
                        Addition = true;
                        editText.setText(null);
                        break;
                    case "-":
                        mValueOne = Float.parseFloat(editText.getText()+"");
                        mSubtract = true;
                        editText.setText(null);
                        break;
                    case "x":
                        mValueOne = Float.parseFloat(editText.getText()+"");
                        Multiplication = true;
                        editText.setText(null);
                    case "/":
                        mValueOne = Float.parseFloat(editText.getText()+"");
                        Division = true;
                        editText.setText(null);
                    default:
                        editText.setText(null);
                }
            }catch (Exception e){
                Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();

            }

        });

    }
}