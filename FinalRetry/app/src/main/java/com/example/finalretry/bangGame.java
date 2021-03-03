package com.example.finalretry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class bangGame extends arthur_start {
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_game);

        next = (Button) findViewById(R.id.next);


        Button sub = (Button) findViewById(R.id.submit);
        final TextView textOne = (TextView) findViewById(R.id.textView4);
        final EditText unum = (EditText) findViewById(R.id.editText2);
        final TextView guessText = (TextView) findViewById(R.id.textView5);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randText = "";
                Random random = new Random();
                int rando = random.nextInt(10) + 1;
                int userNumber = Integer.parseInt(unum.getText().toString());

                if( userNumber == rando)
                {
                    guessText.setText("You hit the dragon");
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           bangBang();
                        }
                    });

                } else {
                    guessText.setText("You missed to make it up you invite the dragon to a tea party.");
                    next.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            beckonDragon();
                        }
                    });
                }

                randText = Integer.toString(rando);
                textOne.setText(randText);


            }
        });
    }
}
