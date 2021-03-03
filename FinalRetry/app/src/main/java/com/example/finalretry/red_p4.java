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

public class red_p4 extends AppCompatActivity {

    Button run;
    Button stand;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_p4);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        run = (Button) findViewById(R.id.run);
        stand = (Button) findViewById(R.id.wait);

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAway();
            }
        });

        stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                standGround();
            }
        });
    }

    public void runAway()
    {
        Intent intent = new Intent(this, red_p6.class);
        startActivity(intent);
    }
    public void standGround()
    {
        Intent intent = new Intent(this, red_p5.class);
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

    public void play_4 (View view)
    {
        if (player == null)
        {
            player = MediaPlayer.create(this, R.raw.red_p4);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause_4 (View view)
    {
        if (player != null)
        {
            player.pause();
        }
    }

    public void stop_4 (View view)
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
