package com.example.irina.travelbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMemories extends AppCompatActivity {

    Button btnAddMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);

        btnAddMemory = findViewById(R.id.btnAddMemory);
    }

    public void OnClick(View v) {
        startActivity(new Intent(this, Array_Activity.class));
    }
}
