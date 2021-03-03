package com.example.finalretry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class choose_story extends AppCompatActivity {
    Spinner storyspinner;
    String stroies[] = {"PICK ONE","Red Envelope", "King Arthur's Realm"};
    ArrayAdapter<String> adapter;
    Button startStoryR;
    Button startStoryA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);

            setContentView(R.layout.activity_choose_story);
            storyspinner =(Spinner)findViewById(R.id.story_list);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stroies);

            storyspinner.setAdapter(adapter);

            storyspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (parent.getItemAtPosition(position).equals("Red Envelope"))
                    {
                        openRedLetter();
                    }

                    if (parent.getItemAtPosition(position).equals("King Arthur's Realm"))
                    {
                        openArthurRealm();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    public void openRedLetter()
    {
        Intent intent = new Intent(this, red_start.class);
        startActivity(intent);
    }

    public void openArthurRealm()
    {
        Intent intent = new Intent(this, arthur_start.class);
        startActivity(intent);
    }
}
