/**
 * Midterm Calculator
 * Sang Dong - A00223629
 * This program works as a simple calculator, performing basic arithmetic operations.
 */


package com.github.iot1009.midterm_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.CharArrayReader;
import java.nio.charset.CharacterCodingException;
import java.util.Stack;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button number0;
    Button number1;
    Button number2;
    Button number3;
    Button number4;
    Button number5;
    Button number6;
    Button number7;
    Button number8;
    Button number9;
    Button plus;
    Button minus;
    Button mul;
    Button div;
    Button equal;
    Button clear;
    TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data.InitData();

        // init components
        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        plus = findViewById(R.id.addition);
        minus = findViewById(R.id.subtraction);
        mul = findViewById(R.id.multiplication);
        div = findViewById(R.id.division);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);
        output = findViewById(R.id.output);

        // assign listeners
        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.number0:
                Data.setExpression("0");
                break;
            case R.id.number1:
                Data.setExpression("1");
                break;
            case R.id.number2:
                Data.setExpression("2");
                break;
            case R.id.number3:
                Data.setExpression("3");
                break;
            case R.id.number4:
                Data.setExpression("4");
                break;
            case R.id.number5:
                Data.setExpression("5");
                break;
            case R.id.number6:
                Data.setExpression("6");
                break;
            case R.id.number7:
                Data.setExpression("7");
                break;
            case R.id.number8:
                Data.setExpression("8");
                break;
            case R.id.number9:
                Data.setExpression("9");
                break;
            case R.id.addition:
                Data.setExpression(" + ");
                break;
            case R.id.subtraction:
                Data.setExpression(" - ");
                break;
            case R.id.multiplication:
                Data.setExpression(" * ");
                break;
            case R.id.division:
                Data.setExpression(" / ");
                break;
            case R.id.equal:
                Data.setExpression(eval() + ""); // passing evaluation for display
                break;
            case R.id.clear:
                Data.clearExpression();
                break;
        }
        output.setText(Data.getExpression());
    }

    // evaluate infix expression
    private double eval() {
        char[] exp = Data.getExpression().replace(" ", "").toCharArray();
        Stack<Double> values = new Stack<Double>();
        Stack<Character> operators = new Stack<Character>();
        String holder = "";

        for (int i = 0; i < exp.length; i++) {
            // numbers detected
            if (exp[i] >= '0' && exp[i] <= '9') {
                while(i < exp.length && exp[i] >= '0' && exp[i] <= '9') {
                    holder += exp[i++];
                }
                values.push(Double.parseDouble(holder));
                holder ="";
                i--; // decrease index by one to correct the offset from line 147
            }
            // operators detected
            else if (exp[i]=='+' || exp[i]=='-' || exp[i]=='*' || exp[i]=='/') {
                while(!operators.empty() && checkPrecedence(exp[i],operators.peek())) {
                    values.push(calculate(operators.pop(),values.pop(),values.pop()));
                }
                operators.push(exp[i]); // push current sign onto operators stack
            }
        } // end of for

        // push the remaining operations
        while(!operators.empty()) {
            values.push(calculate(operators.pop(),values.pop(),values.pop()));
        }
        Data.clearExpression(); // clear calculations for result display
        return values.pop();
    }

    // check for sign priority
    private boolean checkPrecedence(char operator1, char operator2) {
        if ((operator1=='*' || operator1=='/') && (operator2=='+' || operator2=='-'))
            return false;
        else
            return true;
    }

    // calculate the expression
    private double calculate(char sign, double operand1, double operand2) {
        switch (sign) {
            case '+':
                return operand2 + operand1;
            case '-':
                return operand2 - operand1;
            case '*':
                return operand2 * operand1;
            case '/':
                return operand2 / operand1;
        }
        return 0;
    }
}