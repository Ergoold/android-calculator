package com.example.calculatwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioActivity extends AppCompatActivity {
    EditText num1;
    EditText num2;

    RadioGroup radios;
    RadioButton add;
    RadioButton sub;
    RadioButton mult;
    RadioButton div;

    Button calc;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        radios = findViewById(R.id.radios);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.multi);
        div = findViewById(R.id.div);

        calc = findViewById(R.id.calc);
        back = findViewById(R.id.back);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
                    Toast.makeText(RadioActivity.this, "Please enter two numbers", Toast.LENGTH_LONG).show();
                    return;
                }

                int op = radios.getCheckedRadioButtonId();
                double result = 0;
                String operation = "";

                switch (op) {
                    case R.id.add:
                        result = Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString());
                        operation = " + ";
                        break;
                    case R.id.sub:
                        result = Double.parseDouble(num1.getText().toString()) - Double.parseDouble(num2.getText().toString());
                        operation = " - ";
                        break;
                    case R.id.multi:
                        result = Double.parseDouble(num1.getText().toString()) * Double.parseDouble(num2.getText().toString());
                        operation = " * ";
                        break;
                    case R.id.div:
                        result = Double.parseDouble(num1.getText().toString()) / Double.parseDouble(num2.getText().toString());
                        operation = " / ";
                        break;
                }

                Intent intent = new Intent(RadioActivity.this, ResultActivity.class);
                intent.putExtra("result", num1.getText() + operation + num2.getText() + " = " + result);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RadioActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
