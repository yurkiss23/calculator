package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot, btnPlus, btnMinus, btnMult, btnDivid;
    TextView display;
    EditText input;
    String func;
    double a, result;
    boolean start = false;
    OnClickListener oclBtnNum, oclBtnFunc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        GetEls();
        GetNumber();
        GetFunction();
    }

    public void GetEls(){
        display = findViewById(R.id.txtDisplay);
        input = findViewById(R.id.txtResult);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMult = findViewById(R.id.btnMult);
        btnDivid = findViewById(R.id.btnDivid);
    }
    public void GetNumber(){
        oclBtnNum = new OnClickListener() {
            @Override
            public void onClick(View v) {
                GetNew();
                switch (v.getId()){
                    case R.id.btn1:
                        input.setText(input.getText().toString() + btn1.getText());
                        break;
                    case R.id.btn2:
                        input.setText(input.getText().toString() + btn2.getText());
                        break;
                    case R.id.btn3:
                        input.setText(input.getText().toString() + btn3.getText());
                        break;
                    case R.id.btn4:
                        input.setText(input.getText().toString() + btn4.getText());
                        break;
                    case R.id.btn5:
                        input.setText(input.getText().toString() + btn5.getText());
                        break;
                    case R.id.btn6:
                        input.setText(input.getText().toString() + btn6.getText());
                        break;
                    case R.id.btn7:
                        input.setText(input.getText().toString() + btn7.getText());
                        break;
                    case R.id.btn8:
                        input.setText(input.getText().toString() + btn8.getText());
                        break;
                    case R.id.btn9:
                        input.setText(input.getText().toString() + btn9.getText());
                        break;
                    case R.id.btn0:
                        input.setText(input.getText().toString() + btn0.getText());
                        break;
                    case R.id.btnDot:
                        input.setText(input.getText().toString() + btnDot.getText());
                        break;
                }
            }
        };
        GetListNum();
    }
    public void GetFunction(){
        input = findViewById(R.id.txtResult);
        display = findViewById(R.id.txtDisplay);
        oclBtnFunc = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnPlus:
                        display.setText(input.getText() + "+");
                        a = Double.parseDouble(input.getText().toString());
                        func = "+";
                        break;
                    case R.id.btnMinus:
                        display.setText(input.getText() + "-");
                        a = Double.parseDouble(input.getText().toString());
                        func = "-";
                        break;
                    case R.id.btnMult:
                        display.setText(input.getText() + "*");
                        a = Double.parseDouble(input.getText().toString());
                        func = "*";
                        break;
                    case R.id.btnDivid:
                        display.setText(input.getText() + "/");
                        a = Double.parseDouble(input.getText().toString());
                        func = "/";
                        break;
                }
                input.setText(null);
            }
        };
        GetListFunc();
    }

    public void Plus(double a, double b){ result = a + b; }
    public void Minus(double a, double b){ result = a - b; }
    public void Mult(double a, double b){ result = a * b; }
    public void Divid(double a, double b){
        if (b == 0){
            input.setText("ERROR");
            return;
        }
        result = a / b;
        input.setText(Double.toString(result));
    }

    public void onbtnResult(View view){
        input = findViewById(R.id.txtResult);
        switch (func){
            case "+":
                Plus(a, Double.parseDouble(input.getText().toString()));
                input.setText(Double.toString(result));
                break;
            case "-":
                Minus(a, Double.parseDouble(input.getText().toString()));
                input.setText(Double.toString(result));
                break;
            case "*":
                Mult(a, Double.parseDouble(input.getText().toString()));
                input.setText(Double.toString(result));
                break;
            case "/":
                Divid(a, Double.parseDouble(input.getText().toString()));
                break;
        }
        display = findViewById(R.id.txtDisplay);
        display.setText(null);
        start = true;
    }

    public void GetNew(){
        if (start == true){
            input.setText(null);
            start = false;
        }
    }
    public void GetListNum(){
        btn1.setOnClickListener(oclBtnNum);
        btn2.setOnClickListener(oclBtnNum);
        btn3.setOnClickListener(oclBtnNum);
        btn4.setOnClickListener(oclBtnNum);
        btn5.setOnClickListener(oclBtnNum);
        btn6.setOnClickListener(oclBtnNum);
        btn7.setOnClickListener(oclBtnNum);
        btn8.setOnClickListener(oclBtnNum);
        btn9.setOnClickListener(oclBtnNum);
        btn0.setOnClickListener(oclBtnNum);
        btnDot.setOnClickListener(oclBtnNum);
    }
    public void GetListFunc(){
        btnPlus.setOnClickListener(oclBtnFunc);
        btnMinus.setOnClickListener(oclBtnFunc);
        btnMult.setOnClickListener(oclBtnFunc);
        btnDivid.setOnClickListener(oclBtnFunc);
    }
}
