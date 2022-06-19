package com.example.a621j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_string, et_integer, et_float, et_boolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        et_string = findViewById(R.id.et_string);
        et_integer = findViewById(R.id.et_integer);
        et_float = findViewById(R.id.et_float);
        et_boolean = findViewById(R.id.et_boolean);
    }

    public void save(View view) {
        String name = et_string.getText().toString();
        int number = Integer.parseInt(et_integer.getText().toString());
        float floatD = Float.parseFloat(et_float.getText().toString());
        boolean booleanD = Boolean.parseBoolean(et_boolean.getText().toString());
        saveString(name);
        saveInteger(number);
        saveFloat(floatD);
        saveBoolean(booleanD);
    }

    void saveString(String name) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", name);
        editor.apply();
    }

    void saveInteger(int number) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("number", String.valueOf(number));
        editor.apply();
    }

    void saveFloat(float floatD) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("float", String.valueOf(floatD));
        editor.apply();
    }

    void saveBoolean(boolean booleanD) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("boolean", String.valueOf(booleanD));
        editor.apply();
    }
}