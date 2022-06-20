package com.example.a621j;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_string, et_integer, et_float;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch _switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        save();
    }

    private void save() {
        Button save = findViewById(R.id.save);
        save.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("long", Long.parseLong(et_string.getText().toString()));
            editor.putInt("int", Integer.parseInt(et_integer.getText().toString()));
            editor.putFloat("float", Float.parseFloat(et_float.getText().toString()));
            editor.putBoolean("boolean", _switch.isChecked());

            editor.apply();
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        });
    }

    private void init() {
        et_string = findViewById(R.id.et_string);
        et_integer = findViewById(R.id.et_integer);
        et_float = findViewById(R.id.et_float);
        _switch = findViewById(R.id._switch);
    }

}