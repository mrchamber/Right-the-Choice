package com.example.finalretry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class arthur_c6 extends AppCompatActivity {

    Button deflect;
    Button inhale;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arthur_c6);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        deflect = (Button) findViewById(R.id.deflect);
        inhale = (Button) findViewById(R.id.inhale);

        deflect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forcePulses();
            }
        });

        inhale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laser();
            }
        });
    }

    public void forcePulses()
    {
        Intent intent = new Intent(this, arthur_c12.class);
        startActivity(intent);
    }
    public void  laser()
    {
        Intent intent = new Intent(this, arthur_c14.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opt_menu, menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.load:
                Toast.makeText(getApplicationContext(), "Game loaded successfully", Toast.LENGTH_SHORT).show();
                break;

            case R.id.save:
                Toast.makeText(getApplicationContext(), "Game saved successfully", Toast.LENGTH_SHORT).show();
                break;

            case R.id.new_game:
                Toast.makeText(getApplicationContext(), "New game loaded successfully", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void play_ac6 (View view)
    {
        if (player == null)
        {
            player = MediaPlayer.create(this, R.raw.realm_c6);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause_ac6 (View view)
    {
        if (player != null)
        {
            player.pause();
        }
    }

    public void stop_ac6 (View view)
    {
        stopPlayer();
    }

    private void stopPlayer()
    {
        if (player !=null)
        {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}
