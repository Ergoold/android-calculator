package com.example.calculatwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonActivity extends AppCompatActivity {
    EditText num1;
    EditText num2;

    Button plus;
    Button minus;
    Button multi;
    Button div;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);

        back = findViewById(R.id.back);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
                    Toast.makeText(ButtonActivity.this, "Please enter two numbers", Toast.LENGTH_LONG).show();
                    return;
                }

                double result = Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString());

                Intent intent = new Intent(ButtonActivity.this, ResultActivity.class);
                intent.putExtra("result", num1.getText() + " + " + num2.getText() + " = " + result);
                startActivity(intent);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
                    Toast.makeText(ButtonActivity.this, "Please enter two numbers", Toast.LENGTH_LONG).show();
                    return;
                }

                double result = Double.parseDouble(num1.getText().toString()) - Double.parseDouble(num2.getText().toString());

                Intent intent = new Intent(ButtonActivity.this, ResultActivity.class);
                intent.putExtra("result", num1.getText() + " - " + num2.getText() + " = " + result);
                startActivity(intent);
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
                    Toast.makeText(ButtonActivity.this, "Please enter two numbers", Toast.LENGTH_LONG).show();
                    return;
                }

                double result = Double.parseDouble(num1.getText().toString()) * Double.parseDouble(num2.getText().toString());

                Intent intent = new Intent(ButtonActivity.this, ResultActivity.class);
                intent.putExtra("result", num1.getText() + " * " + num2.getText() + " = " + result);
                startActivity(intent);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
                    Toast.makeText(ButtonActivity.this, "Please enter two numbers", Toast.LENGTH_LONG).show();
                    return;
                }

                double result = Double.parseDouble(num1.getText().toString()) / Double.parseDouble(num2.getText().toString());

                Intent intent = new Intent(ButtonActivity.this, ResultActivity.class);
                intent.putExtra("result", num1.getText() + " / " + num2.getText() + " = " + result);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ButtonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
