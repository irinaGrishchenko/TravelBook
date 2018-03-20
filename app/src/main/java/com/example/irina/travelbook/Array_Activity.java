package com.example.irina.travelbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Array_Activity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    ListView listView;
    String[] countries;

    SharedPreferences sPref;

    final String COUNTRY_NAME = "country_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_);

        listView = findViewById(R.id.listView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        countries = getResources().getStringArray(R.array.countries);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                listView.getItemAtPosition(position);
                String text = listView.getItemAtPosition(position).toString();
                startActivity(new Intent(Array_Activity.this, ActivityMemory.class));
                saveText();
                Log.d(LOG_TAG, "You choose: " + text);

            }
        });
    }

    void saveText() {
        sPref = getSharedPreferences("Country", MODE_PRIVATE );
        SharedPreferences.Editor editor = sPref.edit(); //для редактирования данных(передать в putString)
        editor.putString(COUNTRY_NAME, )
    }
}
