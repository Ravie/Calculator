package com.ravie.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity
{
    private Float InMemory = 0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void operation(View v)
    {
        EditText Num1_input = (EditText) findViewById(R.id.Num1);
        EditText Num2_input = (EditText) findViewById(R.id.Num2);
        TextView result_output = (TextView) findViewById(R.id.result);
        Float result, num1, num2;

        if (Num1_input.getText().toString().equals(""))
            num1 = 0.0f;
        else
            num1 = Float.parseFloat(Num1_input.getText().toString());
        if (Num2_input.getText().toString().equals(""))
            num2 = 0.0f;
        else
            num2 = Float.parseFloat(Num2_input.getText().toString());

        if (v.getId() == R.id.sum_result)
            result = num1 + num2;
        else if (v.getId() == R.id.sub_result)
            result = num1 - num2;
        else if (v.getId() == R.id.mult_result)
            result = num1 * num2;
        else /*if (v.getId() == R.id.div_result)*/
            result = num1 / num2;

        result_output.setText(String.format(Locale.getDefault(), "%f", result));
    }

    public void memory_save(View v)
    {
        TextView result_output = (TextView) findViewById(R.id.result);
        if (!result_output.getText().toString().equals(""))
            InMemory = Float.parseFloat(result_output.getText().toString());
    }

    public void memory_clear(View v)
    {
        InMemory = 0.0f;
    }

    public void memory_read(View v)
    {
        TextView result_output = (TextView) findViewById(R.id.result);
        result_output.setText(String.format(Locale.getDefault(), "%f", InMemory));
    }

    public void memory_add(View v)
    {
        TextView result_output = (TextView) findViewById(R.id.result);
        Float num = 0.0f;
        if (!result_output.getText().toString().equals(""))
            num = Float.parseFloat(result_output.getText().toString());
        InMemory += num;
    }

    public void memory_deduct(View v)
    {
        TextView result_output = (TextView) findViewById(R.id.result);
        Float num = 0.0f;
        if (!result_output.getText().toString().equals(""))
            num = Float.parseFloat(result_output.getText().toString());
        InMemory -= num;
    }
}
