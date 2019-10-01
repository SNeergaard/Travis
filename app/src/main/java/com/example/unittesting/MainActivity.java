package com.example.unittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvOutput;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.etUserInput);
        tvOutput = findViewById(R.id.tvOutput);
    }

    public void onClick(View view) {
        final String userInput = etInput.getText().toString();
        tvOutput.setText(userInput);
    }
}
