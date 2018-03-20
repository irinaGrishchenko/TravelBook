package com.example.irina.travelbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityMemory extends AppCompatActivity {

    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
    }

    public void OnClick (View v ) {
        startActivity(new Intent(this, Array_Activity.class));
    }
}
